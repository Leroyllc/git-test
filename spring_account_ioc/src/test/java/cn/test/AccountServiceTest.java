package cn.test;

import cn.domain.Account;
import cn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Junit单元测试
 */
public class AccountServiceTest {
    //1.获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    //2.得到业务层对象
    AccountService as = ac.getBean("accountService",AccountService.class);

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
        AccountService as = ac.getBean("accountService",AccountService.class);
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
