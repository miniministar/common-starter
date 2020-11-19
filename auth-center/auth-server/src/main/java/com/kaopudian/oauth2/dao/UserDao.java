package com.exercise.oauth2.dao;

import com.exercise.oauth2.model.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 根据用户id 查询用户权限
    public List<String> findPermissionByUserId(Long userId)
    {
        String sql = "select id , permission, uri, name from sys_permission where id in (" +
                "select permission_id from sys_role_permission where role_id in (" +
                "select role_id from sys_role_user where user_id = ?" +
                ")" +
                ")";
        List<SysPermission> result = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(SysPermission.class));
        List<String> permissions = new ArrayList<String>();
        result.forEach( p->permissions.add(p.getPermission()) );
        return permissions;

    }
}
