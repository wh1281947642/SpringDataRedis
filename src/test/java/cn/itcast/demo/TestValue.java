package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * <code>TestValue</code>
 * </p>
 * 值类型操作
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/05/12 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/12 20:29
     * @param
     * @return 
     */
    @Test
    public void setValue(){
        redisTemplate.boundValueOps("name").set("itcast");
    }

    /**
     * 存值（有过期时间）
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/12 20:29
     * @param
     * @return
     */
    @Test
    public void setValue1(){
        redisTemplate.boundValueOps("name").set("itcast");
        redisTemplate.boundValueOps("name").expire(10,TimeUnit.SECONDS);
    }

    /**
     * 取值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/12 20:29
     * @param
     * @return
     */
    @Test
    public void getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * 删除
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 11:39
     * @param
     * @return
     */
    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }
}
