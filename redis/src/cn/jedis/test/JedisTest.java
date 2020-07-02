package cn.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test(){
        Jedis jedis = new Jedis();
        System.out.println(1);
        jedis.set("username","zhangsan");
        System.out.println(2);
        jedis.close();
        System.out.println(3);
    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis("localhost",6379);

        jedis.set("username","zhangsan");

        jedis.close();
    }

    @Test
    public void test3(){
       //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool();

        //2.获取连接池对象
        Jedis jedis = jedisPool.getResource();

//        redis.pool.maxWaitMillis=10000;
        //3.使用连接池
        jedis.set("username","zhangsan");

        jedis.close();
    }
}
