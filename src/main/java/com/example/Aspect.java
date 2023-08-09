package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private static final Logger logger = LoggerFactory.getLogger(Aspect.class);

    @Before("@annotation(LogMethodCall)")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Method {} is called.", joinPoint.getSignature().getName());
    }

    @Around("@annotation(MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method {} took {}ms to execute.", joinPoint.getSignature().getName(), (endTime - startTime));
        return result;
    }
}
