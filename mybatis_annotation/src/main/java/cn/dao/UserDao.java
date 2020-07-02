package cn.dao;

import cn.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();
}
