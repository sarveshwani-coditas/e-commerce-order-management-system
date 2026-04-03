package com.coditas.ecommerceordermanagementsystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    //1
    @Before("execution(* com.coditas.ecommerceordermanagementsystem.service.*.placeOrder(..))")
    public void securityCheckForCustomer(){
        String role = "CUSTOMER";
        if(!role.equals("CUSTOMER")) {
            throw new RuntimeException("Access Denied");
        }
    }

    //3
    @Before("execution(* com.coditas.ecommerceordermanagementsystem.service.*.updateProduct(..))")
    public void securityCheckForAdmin(){
        String role = "ADMIN";
        if(!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied");
        }
    }


}
