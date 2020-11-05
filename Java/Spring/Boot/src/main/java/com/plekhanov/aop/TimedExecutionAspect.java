package com.plekhanov.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class TimedExecutionAspect {

    @Around("@annotation(TimedExecution)")
    public Object timedExecution(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        final String methodName = pjp.getStaticPart().toShortString();

        log.info("Started {}", methodName);
        final Object proceed = pjp.proceed();
        log.info("Completed {} in {} ms", methodName, System.currentTimeMillis() - start);

        return proceed;
    }
}
