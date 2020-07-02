package cn.dao.impl;

import cn.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("AccountImpl保存了账户");
    }
}
