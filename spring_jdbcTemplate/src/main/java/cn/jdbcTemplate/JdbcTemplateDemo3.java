package cn.jdbcTemplate;

import cn.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        //查询所有
        List<Account> accounts = jt.query("select * from account where money > ?",
                new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        for(Account account : accounts){
            System.out.println(account);
        }

        //查询一个
        List<Account> accounts1 = jt.query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), 0);
        System.out.println(accounts1.isEmpty()?"没有":accounts1.get(0));
    }
}

