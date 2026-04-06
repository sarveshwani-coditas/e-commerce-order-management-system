package com.coditas.ecommerceordermanagementsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class UserLoginAspect {

    @AfterReturning(
            pointcut = "execution(* com.coditas.ecommerceordermanagementsystem.service.UserService.loginUser(..) )",
            returning = "result"
    )
    public void loginSuccess(JoinPoint joinPoint, Object result){
        System.out.println("Login Success!");
        System.out.println("Login timestamp: "+ LocalDateTime.now());
    }

    @AfterThrowing(
            pointcut = "execution(* com.coditas.ecommerceordermanagementsystem.service.UserService.loginUser(..) )",
            throwing = "ex"
    )
    public void loginFailure(JoinPoint joinPoint, Throwable ex){
        System.out.println("Failed Attempt!");
        int failedLogin = 0;
        System.out.println("Login timestamp: "+ LocalDateTime.now());
        failedLogin++;
        System.out.println("Failed login counter: "+failedLogin);
        if(failedLogin == 3){
            securityAlert();
        }
    }

    private void securityAlert() {
        System.out.println("You have exceeded 3 chances...");
    }


}
