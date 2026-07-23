package com.cognizant.librarymanagementcore.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.cognizant.librarymanagementcore.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("Logging: Before method execution");
    }

    @After("execution(* com.cognizant.librarymanagementcore.service.*.*(..))")
    public void afterMethod() {
        System.out.println("Logging: After method execution");
    }
}