package com.example.task14.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import org.aspectj.lang.annotation.Around;

@Slf4j
@Aspect // Включаем аспекты
@Component
public class TimeAspect {
    @Around("allServiceMethods()")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        log.info("Method: {} from {}, Time: {} ms", methodName, className, timeElapsed);
        return result;
    }
    @Pointcut("within(com.example.task14.service.*)")
    public void allServiceMethods() {}

}
