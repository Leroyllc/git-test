package cn.ui;

import cn.service.AccountService;
import cn.service.impl.AccountServiceImpl;
import cn.service.impl.AccountServiceImpl3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountServiceImpl as = (AccountServiceImpl) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService2");
        AccountService as3 = (AccountServiceImpl3) ac.getBean("accountService3");

        as.saveAccount();
        System.out.println(as);

        as2.saveAccount();
        System.out.println(as2);

        as3.saveAccount();
        System.out.println(as3);
    }
}
