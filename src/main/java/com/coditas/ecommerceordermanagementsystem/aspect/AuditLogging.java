package com.coditas.ecommerceordermanagementsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class AuditLogging {

    @After("execution(* com.coditas.ecommerceordermanagementsystem.service.*.*(..))")
    public void auditAll(JoinPoint joinPoint){

        String method = joinPoint.getSignature().toShortString();
        String classname = joinPoint.getClass().getSimpleName();
        System.out.println("Class Name: " + classname);
        System.out.println("Method Name: " + method);
        System.out.println("TimeStamp: "+ LocalDateTime.now());
    }
}
