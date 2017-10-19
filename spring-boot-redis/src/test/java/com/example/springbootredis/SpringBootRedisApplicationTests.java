package com.example.springbootredis;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, SysDict> redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSet() throws Exception {
        stringRedisTemplate.opsForValue().set("aa", "11");
    }

    @Test
    public void testGet() throws Exception {
        System.out.println(stringRedisTemplate.opsForValue().get("aa"));
    }

    @Test
    public void testGetHash() throws Exception {
        SysDict ccb = redisTemplate.<String, SysDict>opsForHash().get("finance.dict.BANK", "CCB");
        System.out.println(ccb);
    }
}
