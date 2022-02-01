package spring.aop.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect// aop's defined stuff
// NOTE: The combination of PointCut and Advice is called Aspect
@Configuration
public class BeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Before : Means that this method needs to be called before execution of something
    @Before("execution(* spring.aop.springaop.business.*.*(..))") // in the quotes, I need to define which method I want to intercept by
    // using PointCut which is in the form of : execution(* PACKAGE.*.*(..))
    public void before(JoinPoint joinPoint) {  // For getting the details, add JoinPoint parameter
        // what in here is called Advice
        logger.info(" Checking .....");
        logger.info(" Intercepted Method Calls - {} ", joinPoint);
    }
    /* So, it intercepts just before the call has happened (before the actual method has been invoked).
    It is typically used for checking before the access, for example: when you want to check that the user
    has the right access.
     */


}
