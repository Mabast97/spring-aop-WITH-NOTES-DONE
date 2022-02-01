package spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* spring.aop.springaop.business.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // ProceedingJoinPoint will allow you to continue with the execution of the method, allow the method to proceed,
        // and then find the time taken
        // It means before the method execution and after, you can do something and intercept it.
        long startTime = System.currentTimeMillis(); // this is the things that you want to do before the method execution.

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime; // this is the things that you want to do after the method execution.
        logger.info("Time taken by {} is {}", joinPoint, timeTaken);
    }
}
