package com.coditas.ecommerceordermanagementsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentTrackingAspect {

    @AfterReturning(
            pointcut = "execution(* com.coditas.ecommerceordermanagementsystem.service.OrderService.paymentGateway(..))",
            returning = "result")
    public void paymentAopSuccess(JoinPoint joinPoint, Object result) {

        Object[] args = joinPoint.getArgs();
        int transaction_id = (int) args[0];

        System.out.println("Transaction_id: " + transaction_id);
        System.out.println("Success message: Payment " + result);

    }

    @AfterThrowing(
            pointcut="execution(* com.coditas.ecommerceordermanagementsystem.service.OrderService.paymentGateway(..))",
            throwing = "ex"
    )
    public void paymentAopFailure(JoinPoint joinPoint, Throwable ex){

        System.out.println("Error Message:"+ex.getMessage());

        String reason = ex.getLocalizedMessage();
        System.out.println("Failure reason: "+reason);
        retry();

    }

    private String retry(){

        int n = 3;
        n--;
        if(n>=0){
            return "Try again";
        }
        else{
            return "You have attempted all 3 chances";
        }
    }
}
