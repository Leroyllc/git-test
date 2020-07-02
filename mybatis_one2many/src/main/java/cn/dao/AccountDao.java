package cn.dao;

import cn.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */

    @Results(id = "accountMap",value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid",
                    one = @One(select = "cn.dao.UserDao.findById", fetchType = FetchType.EAGER))
    })
    @Select("select * from account")
    List<Account> findAll();

    @Select("select * from account where uid = #{id}")
    List<Account> findById(int id);
}
