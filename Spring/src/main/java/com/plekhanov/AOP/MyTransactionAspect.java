package com.plekhanov.AOP;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by AtagaN on 18.01.2019.
 */
@Component
@Aspect
public class MyTransactionAspect {

    @Before("execution(* com.plekhanov.AOP.MyRepository.getInfo())")
    public void beginTransaction() {
        System.out.println("begin Transaction");
    }

    @After("execution(* com.plekhanov.AOP.MyRepository.getInfo())")
    public void after() {
        System.out.println("after Transaction");
    }

    @AfterReturning("execution(* com.plekhanov.AOP.MyRepository.getInfo())")
    public void commitTransaction() {
        System.out.println("commit Transaction");
    }

    @AfterThrowing("execution(* com.plekhanov.AOP.MyRepository.getInfo())")
    public void rollback() {
        System.out.println("rollback Transaction");
    }
}
