package cn.test;

import cn.dao.UserDaoImpl;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream is;
    private UserDaoImpl dao;
    private SqlSession session;

    @Before
    public void inni() throws IOException {
        //1.读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.使用工厂生产SqlSession
        session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        dao = session.getMapper(UserDaoImpl.class);
    }

    @After
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        is.close();
    }

    @Test   //测试findAll方法
    public void testFindAll() throws IOException {
        //5.使用代理对象执行方法
        List<User> users = dao.findAll();
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test //测试保存用户方法
    public void testSaveUser() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("湖南省邵东市");
        user.setSex("男");
        user.setBirthday(new Date());

        dao.saveUser(user);
    }

    @Test //测试修改用户方法
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("李四");
        user.setAddress("湖南省邵东市");
        user.setSex("女");
        user.setBirthday(new Date());

        dao.updateUser(user);
    }

    @Test //测试删除用户方法
    public void testDeleteUser() {
        dao.deleteUser(51);
    }

    @Test   //测试根据ID查询用户
    public void testFindById(){
        User user = dao.findById(48);
        System.out.println(user);
    }

    @Test //模糊查询
    public void testFindByName(){
       List<User> users = dao.findByName("%王%");
       for(User user:users){
           System.out.println(user);
       }
    }

    @Test //查询所有记录
    public void testFindTotal(){
        System.out.println(dao.findTotal());
    }
}
