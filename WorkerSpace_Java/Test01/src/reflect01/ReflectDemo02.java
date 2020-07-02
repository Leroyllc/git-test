package reflect01;

import java.lang.reflect.Field;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        //获取成员变量
        Field[] fields = personClass.getFields();   //获取public修饰的成员变量
        for(Field f:fields){
            System.out.println(fields[0]);
        }

        Field f = personClass.getField("a");
        Person p = new Person();
        Object value = f.get(p);
        System.out.println(value);
        f.set(p,10);
        System.out.println(p);
        System.out.println("------------------");

        Field[] declaredFields = personClass.getDeclaredFields();
        for(Field df: declaredFields){
            System.out.println(df);
        }


        Person p2 = new Person();
        Field f2 = personClass.getDeclaredField("name");
        //忽略访问权限修饰符的安全检测 可以查看类中的私有成员变量
        f2.setAccessible(true); //暴力反射
        Object value2 = f2.get(p2);

        System.out.println(value2);
        f2.set(p2,"李四");
        System.out.println(p2);
    }
}
