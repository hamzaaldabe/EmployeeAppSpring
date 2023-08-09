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



    @Before("@annotation(LogMethodCall)")
    public void logMethodCall(JoinPoint joinPoint) {
        System.out.println("Method "+ joinPoint.getSignature().getName()+" is called." );
    }

    @Around("@annotation(MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Method " + joinPoint.getSignature().getName() + " took " +  (endTime - startTime) + "ms to execute. ");
        return result;
    }
}
