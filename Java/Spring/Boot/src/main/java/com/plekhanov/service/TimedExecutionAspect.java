package com.plekhanov.service;

//@Slf4j
//@Aspect
//@Component
//@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
//public class TimedExecutionAspect {
//
//    @Around("@annotation(TimedExecution)")
//    public Object timedExecution(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        final String methodName = pjp.getStaticPart().toShortString();
//
//        log.info("Started {}", methodName);
//        final Object proceed = pjp.proceed();
//        log.info("Completed {} in {} ms", methodName, System.currentTimeMillis() - start);
//
//        return proceed;
//    }
//}