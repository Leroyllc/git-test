package projectLogin.dao;

import com.alibaba.druid.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import projectLogin.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import projectLogin.util.JDBCUtil;

import javax.sql.DataSource;

/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //生命JDBCTemplate对象公用
    private  JdbcTemplate template= new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user类的全部数据 没查询到 返回null
     */
    public User login(User loginUser){
       try{
           //1.编写SQL
           String sql = "select * from user where username = ? and password = ?";
           //2.调用query方法
           User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                   loginUser.getUsername(), loginUser.getPassword());
           return user;
       }catch (DataAccessException e){
           e.printStackTrace(); //记录日志
           return null;
       }
    }
}
