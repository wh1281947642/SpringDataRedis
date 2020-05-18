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
 * List 类型操作
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/05/12 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右压栈：后添加的对象排在后边   
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 11:58
     * @param
     * @return
     */
    @Test
    public void testSetValue1(){
        redisTemplate.boundListOps("namelist1").rightPush("刘备");
        redisTemplate.boundListOps("namelist1").rightPush("关羽");
        redisTemplate.boundListOps("namelist1").rightPush("张飞");
    }

    /**
     * 显示右压栈集合   
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 11:59
     * @param
     * @return
     */
    @Test
    public void testGetValue1(){
        //range(开始索引，查询个数) 查询个数为-1 不限制个数
        List list = redisTemplate.boundListOps("namelist1").range(0,10);
        System.out.println(list);
    }
    
    /**
     * 左压栈：后添加的对象排在前边    
     * @description 
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:21
     * @param 
     * @return 
     */
    @Test
    public void testSetValue2(){
        redisTemplate.boundListOps("namelist2").leftPush("刘备");
        redisTemplate.boundListOps("namelist2").leftPush("关羽");
        redisTemplate.boundListOps("namelist2").leftPush("张飞"); 
    }

    /**
     * 显示左压栈集合    
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:22
     * @param 
     * @return 
     */
    @Test
    public void testGetValue2(){
        List list = redisTemplate.boundListOps("namelist2").range(0, 10); 
        System.out.println(list); 
    }

    /**
     * 根据索引查询元素
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:29
     * @param
     * @return 
     */
    @Test
    public void testSearchByIndex(){ 
        String s = (String) redisTemplate.boundListOps("namelist1").index(1);
        System.out.println(s); 
    }

    /**
     * 移除指定个数的值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:30
     * @param
     * @return 
     */
    @Test
    public void testRemoveByIndex(){
        redisTemplate.boundListOps("namelist1").remove(1, "关羽"); 
    }
}
