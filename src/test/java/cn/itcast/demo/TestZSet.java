package cn.itcast.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * <code>TestValue</code>
 * </p>
 * ZSet类型操作
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/05/12 20:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class TestZSet {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值 ，指定分值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/12 20:29
     * @param
     * @return 
     */
    @Test
    public void setValue(){
        redisTemplate.boundZSetOps("namezset").add("曹操",100000);
        redisTemplate.boundZSetOps("namezset").add("孙权",0);
        redisTemplate.boundZSetOps("namezset").add("刘备",1000);
    }

    /**
     * 查询，由低到高
     * @description 
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 14:39
     * @param
     * @return 
     */
    @Test
    public void testGetKeys() {
        Set namezset = redisTemplate.boundZSetOps("namezset").range(0, -1);
        System.out.println(namezset);
    }

    /**
     * 由高到底排序（土豪榜）
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 15:20
     * @param
     * @return
     */
    @Test
    public void tuhaobang(){
        Set namezset = redisTemplate.boundZSetOps("namezset").reverseRange(0,9);
        System.out.println(namezset);
   }
    
    /**
     * 增加分值
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 15:22
     * @param
     * @return
     */
    @Test
    public void addScore(){
        redisTemplate.boundZSetOps("namezset").incrementScore("孙权",2000);
    }

    /**
     * 查询值和分数
     * @description
     * @author huiwang45@iflytek.com
     * @date 2020/05/18 15:23
     * @param
     * @return
     */
    @Test
    public void getValueAndScore(){
        Set<ZSetOperations.TypedTuple> namezset = redisTemplate.boundZSetOps("namezset").reverseRangeWithScores(0, -1);
        for(ZSetOperations.TypedTuple typedTuple:namezset){
            System.out.println("姓名："+typedTuple.getValue());
            System.out.println("金币："+typedTuple.getScore());
        }
    }
}
