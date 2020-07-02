package cn.factory;

import cn.domain.Account;
import cn.service.AccountService;
import cn.utils.TransactionManager;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {
    @Autowired
    private TransactionManager tm;

    public void setTm(TransactionManager tm) {
        this.tm = tm;
    }

    private AccountService accountService;

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取代理对象
     * @return
     */
    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param o
                     * @param method
                     * @param objects
                     * @return
                     * @throws Throwable
                     */
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

                Object rtValue = null;
                try {
                    //1.开启事务
                    tm.beginTransaction();
                    //2.执行事务
                    rtValue = method.invoke(accountService,objects);
                    //3.提交事务
                    tm.commitTransaction();
                    //4.返回结果
                    return rtValue;
                } catch (Exception e) {
                    //5.回滚事务
                    tm.rollbackTransaction();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放连接
                    tm.releaseTransaction();
                }
            }
        });
    }
}
