package com.example.cache.config;

import static java.util.Objects.*;
import static java.util.stream.Collectors.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.example.cache.annotation.Cacheable;

@Component
@Aspect
public class CacheAspect {
    private final ValueOperations<String, Object> operations;

    public CacheAspect(RedisTemplate redisTemplate) {
        this.operations = redisTemplate.opsForValue();
    }

    @Around("@annotation(Cacheable)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        final String prefix = getCacheName(joinPoint);
        final String key = generateKey(joinPoint);

        final String cacheKey = String.format("%s:%s", prefix, key);
        final Object cachedValue = this.operations.get(cacheKey);

        if (isNull(cachedValue)) {
            final Object result = joinPoint.proceed();
            this.operations.set(cacheKey, result);
            return result;
        } else {
            return cachedValue;
        }
    }
    private String getCacheName(ProceedingJoinPoint joinPoint) {
        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final Method method = signature.getMethod();
        final Cacheable cacheable = AnnotationUtils.getAnnotation(method, Cacheable.class);

        return cacheable.cacheName();
    }

    private String generateKey(ProceedingJoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
            .map(args -> Integer.toString(args.hashCode()))
            .collect(joining(":"));
    }
}
