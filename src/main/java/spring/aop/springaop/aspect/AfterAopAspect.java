package spring.aop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect// aop's defined stuff
// NOTE: The combination of PointCut and Advice is called Aspect
@Configuration
public class AfterAopAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @AfterReturning : Means that this method will be called after execution of something happened successfully
    @AfterReturning(value="execution(* spring.aop.springaop.business.*.*(..))",
                    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {  // For getting the details, add JoinPoint parameter
        // what in here is called Advice
        logger.info("{} returned with value {}", joinPoint, result);
    }

    // When throwing an exception, you can use it.
    @AfterThrowing(value="execution(* spring.aop.springaop.business.*.*(..))",
                    throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("{} returned with value {}", joinPoint, exception);
    }

    // Whether it's throwing an exception or returning a value, you can use the @After
    @After(value="execution(* spring.aop.springaop.business.*.*(..))" )
    public void after(JoinPoint joinPoint ) {
        logger.info("after execution of {}", joinPoint );
    }

}
