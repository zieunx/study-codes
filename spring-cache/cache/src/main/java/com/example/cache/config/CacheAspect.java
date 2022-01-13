package com.example.cache.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CacheAspect {
    private final ValueOperations<String, Object> operations;

    public CacheAspect(RedisTemplate redisTemplate) {
        this.operations = redisTemplate.opsForValue();
    }

    @Around("@annotation(Cacheable)")
    public Object cache(ProceedingJoinPoint joinPoint) {
        final String prefix = getCacheName(joinPoint);
    }
}
