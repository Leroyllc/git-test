package cn.factory;

import cn.service.AccountService;
import cn.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
