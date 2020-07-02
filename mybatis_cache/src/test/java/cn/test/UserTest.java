package cn.test;

import cn.dao.UserDao;
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
    private SqlSessionFactory factory;

    @Before
    public void inni() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(is);
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

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = dao.findById(41);
        System.out.println(user1);

//        重新启动session对象会清空缓存
//        session.close();
//        session = factory.openSession(true);
//
//        dao = session.getMapper(UserDao.class);
        session.clearCache();

        User user2 = dao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }


    @Test
    public void testClearCache(){
        User user1 = dao.findById(41);
        System.out.println(user1);

        user1.setUsername("updateUser");
        user1.setAddress("updateUser");
        dao.updateUser(user1);

        User user2 = dao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }
}
