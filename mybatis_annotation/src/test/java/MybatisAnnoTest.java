import cn.dao.UserDao;
import cn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    private static InputStream is;
    /**
     * 测试基于注解的mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.findAll();
        for(User user: users){
            System.out.println(user);
        }
    }
}
