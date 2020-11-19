package com.exercise.security.service.impl;

import com.exercise.security.service.RoleService;
import com.exercise.security.service.RoleUserService;
import com.exercise.security.service.SystemUserService;
import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.common.Myproperties;
import com.exercise.security.dto.UserPasswordPara;
import com.exercise.security.mapper.SysUserMapper;
import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysUser;
import com.exercise.security.model.SysUserExample;
import com.exercise.security.model.SysUserType;
import com.exercise.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SysUserMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleUserService roleUserService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private Myproperties myproperties;

    @Override
    public long countByExample(SysUserExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public String encode(String password) {
       return passwordEncoder.encode(password);
    }

    @Override
    public int insertSelective(SysUser record) {
        if(StringUtils.isEmpty(record.getPassword())) {
            record.setPassword(myproperties.getAuth().getDefaultPwd());
        }
        record.setPassword(encode(record.getPassword()));
        List<SysRole> roles = record.getRoles();
        record.setRoles(null);
        int i = mapper.insertSelective(record);
        roleUserService.setUserRole(record, roles);
        return i;
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        SysUser sysUser = mapper.selectByPrimaryKey(id);
        sysUser = filterRow(sysUser);
        return sysUser;
    }

    @Override
    public SysUser filterRow(SysUser sysUser) {
        sysUser.setRoles(roleUserService.getUserAllRole(sysUser.getId()));
        return sysUser;
    }

    @Override
    public List<SysUser> filterRows(List<SysUser> list) {
        if(CollectionUtils.isEmpty(list)) return list;

        List<SysUser> newList = new ArrayList<>();
        for (SysUser sysUser: list) {
            sysUser = filterRow(sysUser);
            newList.add(sysUser);
        }
        return newList;
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        roleUserService.setUserRole(record, record.getRoles());
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByExample(SysUser record, SysUserExample example) {
        roleUserService.setUserRole(record, record.getRoles());
        return mapper.updateByExample(record, example);
    }

    @Override
    public ResultDTO<SysUser> getPage(RequestDTO<SysUser> params) {
        SysUser filter = params.getFilter();
        SysUserExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysUser> list = selectByExample(example);
        ResultDTO<SysUser> page = ResultDTO.restPage(list);

        page.setData( filterRows(page.getData()) );
        return page;
    }

    @Override
    public SysUserExample setCondition(SysUser filter) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( filter.getId() != null ) {
                criteria.andIdEqualTo(filter.getId() );
            }
            if( filter.getUserTypeId() != null ) {
                criteria.andUserTypeIdEqualTo(filter.getUserTypeId() );
            }
            if( !StringUtils.isEmpty(filter.getFullname()) ) {
                criteria.andFullnameLike(filter.getFullname());
            }
            if( !StringUtils.isEmpty(filter.getUsername()) ) {
                criteria.andUsernameLike("%" + filter.getUsername() + "%");
            }
        }
        return example;
    }

    @Override
    public int updateUserType(SysUserType record) {
        SysUser updateData = new SysUser();
        updateData.setType(record.getType());

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserTypeIdEqualTo(record.getId());

        return updateByExample(updateData, example);
    }

    @Override
    public SysUser getInitInfo() {
        SysUser currentUser = SecurityUtil.getCurrentUser();
        if(currentUser == null || currentUser.getId() == null) throw new ApiException("token错误");
        List<SysRole> roles = roleUserService.getUserAllRole(currentUser.getId());

        //currentUser.setRoles(roles);
        if(CollectionUtils.isEmpty(roles)) return currentUser;

        List<Long> collect = roles.stream().map(SysRole::getId).collect(Collectors.toList());
        currentUser.setMenus(roleService.getRolesAllMenus(collect));

        return currentUser;
    }

    @Override
    public boolean changePassword(UserPasswordPara input) {

        SysUser user = selectByUsername(input.getUsername());
        if (user == null) {
            throw new ApiException("用户名不存在");
        }
        boolean correct =  verifyPassword(input.getOldPassword(), user.getPassword());
        if(!correct) throw new ApiException("旧密码输入错误");
        user.setPassword(encode( input.getPassword() ));
        mapper.updateByPrimaryKeySelective(user);

        return true;
    }

    public boolean verifyPassword(String plain, String cip) {
        return passwordEncoder.matches(plain, cip);
    }

    public SysUser selectByUsername(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> sysUsers = selectByExample(example);
        if(CollectionUtils.isEmpty(sysUsers))
        return null;
        return sysUsers.get(0);
    }

    @Override
    public boolean resetPassword(String username) {
        SysUser user = selectByUsername(username);
        if (user == null) {
            throw new ApiException("用户名不存在");
        }
        user.setPassword(encode( myproperties.getAuth().getDefaultPwd() ));
        mapper.updateByPrimaryKeySelective(user);
        return true;
    }
}
