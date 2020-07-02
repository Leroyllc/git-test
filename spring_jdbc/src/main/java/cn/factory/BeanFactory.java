package cn.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map用于存储beans，称之为容器
    private static Map<String,Object> beans;

    static {
        //加载类对象
        try {
            props = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);

            //实例化容器
            beans = new HashMap<String, Object>();

            //取出配置文件中所有的key
            Enumeration keys = props.keys();

//            遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //找到路径
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object obj = Class.forName(beanPath).newInstance();
                //加入容器
                beans.put(key,obj);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }

    }

//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }

    public static Object getBean(String beanName){
        Object obj = beans.get(beanName);
        return obj;
    }
}
