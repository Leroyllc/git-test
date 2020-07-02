package cn.service.impl;

import cn.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {
    private String[] strs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProp;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProp(Properties myProp) {
        this.myProp = myProp;
    }

    public void saveAccount(){
        System.out.println("AccountServiceImpl的saveAccount方法执行了");
    }

    @Override
    public String toString() {
        return "AccountServiceImpl3{" +
                "strs=" + Arrays.toString(strs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProp=" + myProp +
                '}';
    }
}
