package org.macchiato.testsupport.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class RunTimeLoggerAspect {

    @Pointcut("execution(* org.macchiato..*(..)) && " +
            "@annotation(org.macchiato.testsupport.annotation.RunningTimeLogging)")
    public void runTimeLoggerPointCut() {

    }

    @Around("runTimeLoggerPointCut()")
    public Object methodLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        String methodName = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getName();
        System.out.println(methodName + "Method 의 수행시간은 총 " + stopWatch.getTotalTimeSeconds() + "초 소요되었습니다.");

        return proceed;
    }
}
