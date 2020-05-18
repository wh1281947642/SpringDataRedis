package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * <code>TestValue</code>
 * </p>
 * Hash类型操作
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/05/12 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class TestHash {

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
        redisTemplate.boundHashOps("namehash").put("a","唐僧");
        redisTemplate.boundHashOps("namehash").put("b","悟空");
        redisTemplate.boundHashOps("namehash").put("c","八戒");
        redisTemplate.boundHashOps("namehash").put("d","沙僧");
    }

    /**
     * 提取所有的KEY
     * @description 
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:39
     * @param
     * @return 
     */
    @Test
    public void testGetKeys(){
        Set s = redisTemplate.boundHashOps("namehash").keys(); 
        System.out.println(s); 
    }

    /**
     * 提取所有的值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:39
     * @param
     * @return 
     */
    @Test
    public void testGetValues(){
        List values = redisTemplate.boundHashOps("namehash").values();
        System.out.println(values);
    }
    
    /**
     * 根据KEY提取值
     * @description 
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:41
     * @param
     * @return 
     */
    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.boundHashOps("namehash").get("b"); 
        System.out.println(object); 
    }

    /**
     * 根据KEY移除值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:41
     * @param
     * @return 
     */
    @Test
    public void testDeleteValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }
}
