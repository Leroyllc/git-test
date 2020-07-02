package cn.service.impl;

import cn.dao.AccountDao;
import cn.dao.impl.AccountImpl;
import cn.factory.BeanFactory;
import cn.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
//    AccountDao accountDao = new AccountImpl();

    public void saveAccount(){
        int i = 1;
        accountDao= (AccountDao) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
        System.out.println(i++);
    }
}
