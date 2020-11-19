package com.exercise.security.dao;

import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysPermission;
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

    // 根据用户id 查询用户权限
    public List<SysRole> findRoleByUserId(Long userId)
    {
        String sql = "SELECT id, code , name, description , create_time as createTime, modify_time as modifyTime " +
                "from sys_role where id in (select role_id from sys_role_user  where user_id  = ? )";
        List<SysRole> result = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(SysRole.class));
        return result;
    }


    /**
     * 查询所有菜单
     * @return
     */
    public List<SysMenu> selectAllMenu()
    {
        String sql = "SELECT id, parent_id as parentId, name, url , path, css, sort, type, is_menu as isMenu, " +
                "hidden , level, create_time as createTime, modify_time as modifyTime " +
                "FROM sys_menu";
        List<SysMenu> result = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(SysMenu.class));
        return result;
    }

    /**
     * 根据url 查询所有菜单
     * @return
     */
    public SysMenu selectMenu(String path)
    {
        String sql = "SELECT id, parent_id as parentId, name, url , path, css, sort, type, is_menu as isMenu, " +
                "hidden , level, create_time as createTime, modify_time as modifyTime " +
                "FROM sys_menu where path = ?";
        SysMenu result = null;
        try {
            result = jdbcTemplate.queryForObject(sql, new Object[]{path}, new BeanPropertyRowMapper<>(SysMenu.class));
            return  result;
        }catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据菜单id 查询所有具有该菜单权限的角色
     * @return
     */
    public List<SysRole> selectRoleByMenuId(Long menuId)
    {
        String sql = "SELECT id, code , name, description, create_time as createTime, modify_time as modifyTime " +
                " from sys_role where id in  (" +
                " SELECT role_id from sys_role_menu where menu_id = ? )";
        List<SysRole> result = jdbcTemplate.query(sql, new Object[]{menuId}, new BeanPropertyRowMapper<>(SysRole.class));
        return result;
    }
}
