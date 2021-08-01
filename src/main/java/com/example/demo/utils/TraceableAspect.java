package com.example.demo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceableAspect {
 
    @Before("@annotation(Traceable)")
    public void trace(JoinPoint joinPoint) throws Throwable {
        System.out.println("Input : " + joinPoint.getArgs()[0]);
        throw new Exception("Error");
    }
 
}