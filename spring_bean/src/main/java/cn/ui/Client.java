package cn.ui;

import cn.service.AccountService;
import cn.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountServiceImpl as = (AccountServiceImpl) ac.getBean("accountService");

        as.saveAccount();
    }
}
