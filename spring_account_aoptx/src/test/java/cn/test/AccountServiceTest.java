package cn.test;

import cn.domain.Account;
import cn.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as = null;

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAll();
        for(Account account: accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
}
