package com.longbow.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * Created by zhangbin on 2017/1/11.
 */
@Slf4j
public class RedisCacheErrorHandler implements CacheErrorHandler {

    public void handleCacheClearError(RuntimeException e, Cache cache) {
        log.info("缓存不可用，继续查询数据库: {}", e.getMessage());
    }

    public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
        log.info("缓存不可用，继续查询数据库: {}", e.getMessage());
    }

    public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
        log.info("缓存不可用，继续查询数据库: {}", e.getMessage());
    }

    public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
        log.info("缓存不可用，继续查询数据库: {}", e.getMessage());
    }
}

