package com.exercise.oauth2.service.Impl;

import com.exercise.oauth2.dao.UserDao;
import com.exercise.oauth2.mapper.SysUserMapper;
import com.exercise.oauth2.model.SysUser;
import com.exercise.oauth2.model.SysUserExample;
import com.exercise.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper mapper;
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = selectByUsername(username);
        if (user == null)
            return null;

        List<String> permissions = findPermissionByUserId(user.getId());
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }

    @Override
    public long countByExample(SysUserExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysUser record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser selectByUsername(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> userList = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList))
            return null;
        return userList.get(0);
    }

    @Override
    public int updateByExampleSelective(SysUser record, SysUserExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<String> findPermissionByUserId(Long id) {
        return userDao.findPermissionByUserId(id);
    }
}
