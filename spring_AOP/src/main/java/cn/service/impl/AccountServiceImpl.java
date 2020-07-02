package cn.service.impl;

import cn.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount() {
        System.out.println("更新");

    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
