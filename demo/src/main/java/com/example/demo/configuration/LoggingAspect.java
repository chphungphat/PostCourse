package com.example.demo.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void serviceLayer() {}

    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before Log: " + joinPoint.getSignature().getName()
                    + "in class: " + joinPoint.getTarget().getClass());
        System.out.println("Before function is called");
    }

    @After("serviceLayer()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After Log: " + joinPoint.getSignature().getName()
                + "in class: " + joinPoint.getTarget().getClass());
        System.out.println("After function is called");
    }

    @AfterThrowing(
            pointcut = "serviceLayer()",
            throwing = "exception"
    )
    public void exceptionHandling(RuntimeException exception) {
        logger.error("Exception happen" + exception.getMessage());
        System.out.println("Exception handling was called");
    }
}
