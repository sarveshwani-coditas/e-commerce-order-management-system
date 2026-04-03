package com.coditas.ecommerceordermanagementsystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class PerformanceMonitoringAspect {


    @Around("execution(* com.coditas.ecommerceordermanagementsystem.service.*.*(..))")
    public Object performance(ProceedingJoinPoint pjp) throws Throwable {

        String method = pjp.getSignature().toShortString();


        long begin = System.currentTimeMillis();

        Object result = null;
        result = pjp.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Total time taken is "+(end-begin));
        return result;

    }

}
