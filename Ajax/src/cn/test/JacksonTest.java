package cn.test;

import cn.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.beans.Transient;
import java.io.File;
import java.util.*;

public class JacksonTest {
    @Test
    public void test01() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //2.创建jackson核心对象 objectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //3.转换
        String s = objectMapper.writeValueAsString(p);

        System.out.println(s);

        //objectMapper.writeValue(new File("D://a.txt"),p);
    }

    @Test
    public void test02() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("李四");
        p1.setAge(24);
        p1.setGender("女");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("王五");
        p2.setAge(25);
        p2.setGender("男");
        p2.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //2.创建jackson核心对象 objectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //3.转换
        String s = objectMapper.writeValueAsString(list);

        System.out.println(s);

        //objectMapper.writeValue(new File("D://a.txt"),p);
    }

    @Test
    public void test03() throws Exception {
        //1.创建person对象
        Map<String, Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",23);
        map.put("gender","男");

        //2.创建jackson核心对象 objectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //3.转换
        String s = objectMapper.writeValueAsString(map);

        System.out.println(s);

        //objectMapper.writeValue(new File("D://a.txt"),p);
    }
}
