package com.wkzt.sell.service;

import com.sun.deploy.trace.Trace;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author hanchao
 * @Data 2017/12/4 10:55
 */
@Component
@Slf4j
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     * @param key
     * @param value 当前时间 + 超时时间
     * @return
     */
    public boolean lock(String key,String value) {
        if( stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        String currentVlaue = stringRedisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(currentVlaue) && Long.parseLong(currentVlaue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            String  oldVlaue= stringRedisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldVlaue) && oldVlaue.equals(currentVlaue)){
                return true;
            }
        }
        return false;
    }

    public void unlock(String key ,String value){
        try {
            String currentvlaue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentvlaue) && currentvlaue.equals(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("【redis分布式锁】解锁异常,{}",e);
        }
    }
}
