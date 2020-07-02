package cn.dao;

import cn.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有
     * @return List
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询
     * @param id
     */
    User findById(int id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询所有记录
     * @return
     */
    int findTotal();
}
