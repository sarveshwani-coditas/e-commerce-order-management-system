package com.coditas.ecommerceordermanagementsystem.aspect;

import com.coditas.ecommerceordermanagementsystem.entity.Resume;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component
public class ResumeMonitoring {

    @AfterReturning(
            pointcut = "execution(* com.coditas.ecommerceordermanagementsystem.service.*.uploadResume(..))",
            returning = "result"
    )
    public void afterResumeSubmission(JoinPoint joinPoint, Object result){

        Resume resume =(Resume) result;

        String fileName = "resume.txt";
        System.out.println("File name: "+resume.getName()+".txt");
        System.out.println("success count: "+resume.getId());
    }

    @AfterThrowing(
            pointcut = "execution(* com.coditas.ecommerceordermanagementsystem.service.*.uploadResume(..))",
            throwing = "ex"
    )
    public void afterResumeSubmissionFailure(JoinPoint joinPoint, Throwable ex){

        System.out.println("Exception Occured: "+ex.getMessage());
        System.out.println("File Upload failed");
        System.out.println("Retry again!");

    }
}
