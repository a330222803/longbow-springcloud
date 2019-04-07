package com.longbow.cache.redisson;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangbin on 2019/4/3.
 */
public interface DistributedLocker {
    void lock(String lockKey);

    void unlock(String lockKey);

    void lock(String lockKey, int timeout);

    void lock(String lockKey, TimeUnit unit , int timeout);
}
