package cn.dao;

import cn.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from user")
    @Results(id="userMap",value = {
            @Result(id = true,property = "userId",column = "id"),
            @Result(property = "username",column = "name"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "userSex",column = "sex"),
            @Result(property = "userBirthday",column = "birthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "cn.dao.AccountDao.findById",fetchType = FetchType.LAZY)),
    })
    List<User> findAll();

    /**
     * 根据id查询
     * @return
     */
    @Select(value = "select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})
    List<User> findById(int id);
}
