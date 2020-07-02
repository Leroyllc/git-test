package cn.service.impl;

import cn.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {
    private String name;
    private int age;
    private Date birthday;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount(){
        System.out.println("AccountServiceImpl的saveAccount方法执行了");
    }
}
