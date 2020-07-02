package reflect01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);

        Object person1 = constructor.newInstance("zhangsan", 20);   //创建对象
        System.out.println(person1);

        Constructor constructor1 = personClass.getConstructor();
        Object person2 = constructor1.newInstance();
        Object person = personClass.newInstance();
        System.out.println(person2);
        System.out.println(person);

        System.out.println("------------------");

        Method method = personClass.getMethod("eat");
        Person person3 = new Person();
        method.invoke(person3);

        Method method2 = personClass.getDeclaredMethod("eat",String.class);
        method2.setAccessible(true);
        method2.invoke(person3,"张三");


        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m.getName());
            System.out.println(m);
        }
    }
}
