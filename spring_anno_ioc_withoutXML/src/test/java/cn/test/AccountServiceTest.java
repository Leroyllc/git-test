package cn.test;

import config.SpringConfiguration;
import cn.domain.Account;
import cn.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Junit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    //2.得到业务层对象
    @Autowired
    private AccountService as;

    @Test
    public void testFindAll() {
        //3.执行方法
        List<Account> accounts = as.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        Account account = as.findById(1);
        System.out.println(account);
    }

    @Test
    public void testAdd() {
        Account account = new Account();
        account.setName("张三");
        account.setMoney(2000);
        as.addAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("李四");
        account.setMoney(2000);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(8);
    }
}
