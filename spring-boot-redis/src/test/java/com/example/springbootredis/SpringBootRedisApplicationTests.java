package com.example.springbootredis;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;

@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Autowired
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
        List<RedisClientInfo> clientList = redisTemplate.getClientList();
        while (true) {
            System.out.println(LocalDateTime.now() + ": " + stringRedisTemplate.opsForValue().get("aa"));
            Thread.sleep(1000L);
        }
    }

    @Test
    public void testGetHash() throws Exception {
        SysDict ccb = redisTemplate.<String, SysDict>opsForHash().get("finance.dict.BANK", "CCB");
        System.out.println(ccb);
    }

    @Test
    public void testSentinelInfo() throws Exception {
        RedisSentinelConnection sentinelConnection = redisTemplate.getConnectionFactory().getSentinelConnection();
        Collection<RedisServer> masters = sentinelConnection.masters();
        System.out.println("master:");
        masters.forEach(System.out::println);
        Collection<RedisServer> slaves = sentinelConnection.slaves(masters.stream().findFirst().get());
        System.out.println("slaves:");
        slaves.forEach(System.out::println);
    }

    @Test
    public void testHAdd() {
        redisTemplate.opsForHash().put("test", "1", "11");
        redisTemplate.opsForHash().put("test", "2", "22");
    }

    @Test
    public void testHDel() {
        Long a01_nt14410 = redisTemplate.opsForHash().delete("test", "1");
        System.out.println(a01_nt14410);
    }
}
