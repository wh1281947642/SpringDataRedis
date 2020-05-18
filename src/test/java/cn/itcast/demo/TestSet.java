package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * <p>
 * <code>TestValue</code>
 * </p>
 * Set类型操作
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/05/12 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class TestSet {

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
        redisTemplate.boundSetOps("nameset").add("曹操");
        redisTemplate.boundSetOps("nameset").add("刘备");
        redisTemplate.boundSetOps("nameset").add("孙权");
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
        Set members = redisTemplate.boundSetOps("nameset").members();
        System.out.println(members);
    }

    /**
     * 删除集合中的某一个值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 11:45
     * @param
     * @return
     */
    @Test
    public void deleteValue(){
        redisTemplate.boundSetOps("nameset").remove("孙权");
    }

    /**
     * 删除整个集合
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 11:52
     * @param
     * @return 
     */
    @Test
    public void deleteAllValue(){
        redisTemplate.delete("nameset");
    }
}
