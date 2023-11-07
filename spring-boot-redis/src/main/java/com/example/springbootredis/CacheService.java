package com.example.springbootredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/** Created by qct on 2017/8/17. */
@Service
public class CacheService {

    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable
    public SysDict getDict(String key) {
        return new SysDict();
    }
}
