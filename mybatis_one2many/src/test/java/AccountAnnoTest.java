import cn.dao.AccountDao;
import cn.dao.UserDao;
import cn.domain.Account;
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

public class AccountAnnoTest {
    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao dao;


    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession(true);
        dao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = dao.findAll();
        for(Account account: accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


//    @Test
//    public void testFindById(){
//        List<User> users = dao.findById(41);
//        for(User user:users){
//            System.out.println(user);
//        }
//    }
}
