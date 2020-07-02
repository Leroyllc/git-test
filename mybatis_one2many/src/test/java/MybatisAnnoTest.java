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

public class MybatisAnnoTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao dao;


    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);
        dao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<User> users = dao.findAll();
        for(User user: users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    @Test
    public void testFindById(){
        List<User> users = dao.findById(41);
        for(User user:users){
            System.out.println(user);
        }
    }
}
