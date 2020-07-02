package cn.dao;

import cn.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有信息
     * @return
     */
    List<Role> findAll();
}
