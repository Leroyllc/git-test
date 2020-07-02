package cn.test;

import cn.dao.AccountDao;
import cn.dao.UserDao;
import cn.domain.Account;
import cn.domain.AccountUser;
import cn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream is;
    private SqlSession session;
    private UserDao dao;

    @Before
    public void inni() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.创建session
        session = factory.openSession(true);
        //3.创建Dao接口的代理对象
        dao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        is.close();
    }

    @Test   //测试findAll方法
    public void testFindAll() throws IOException {
        //5.使用代理对象执行方法
        List<User> users = dao.findAll();
        for(User user: users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


//    @Test   //测试根据ID查询用户
//    public void testFindById(){
//        Account user = dao.findById(48);
//        System.out.println(user);
//    }

}
