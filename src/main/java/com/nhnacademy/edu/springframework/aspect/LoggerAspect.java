package com.nhnacademy.edu.springframework.aspect;

import com.nhnacademy.edu.springframework.BootStrap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(BootStrap.class);
    @Around("execution(* com.nhnacademy.edu.springframework.*.*.*(..))")
    public Object loggingSendMessage(ProceedingJoinPoint pjp)throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info("실행메서드 ["+pjp.getSignature().getName()+"]");
            log.info(stopWatch.prettyPrint());
        }
    }

}
