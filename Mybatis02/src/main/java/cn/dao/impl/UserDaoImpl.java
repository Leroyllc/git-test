package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用session
        List<User> list = session.selectList("cn.dao.UserDao.findAll");
        //3.释放资源
        session.close();
        return list;
    }

    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用session
        session.insert("cn.dao.UserDao.saveUser",user);
        session.commit();
        //3.释放资源
        session.close();
    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用session
        session.update("cn.dao.UserDao.updateUser",user);
        session.commit();
        //3.释放资源
        session.close();
    }

    public void deleteUser(Integer id) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用session
        session.update("cn.dao.UserDao.deleteUser",id);
        session.commit();
        //3.释放资源
        session.close();
    }

    public User findById(int id) {
        return null;
    }

    public List<User> findByName(String name) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
