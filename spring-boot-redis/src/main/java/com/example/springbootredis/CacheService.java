package com.example.springbootredis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>Created by Damon.Q on 2017/8/17.
 */
@Service
public class CacheService {

    @Cacheable
    public SysDict getDict(String key) {
        return new SysDict();
    }
}
