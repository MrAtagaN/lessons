package com.plekhanov.AOP;

import org.springframework.stereotype.Component;

/**
 * Created by AtagaN on 18.01.2019.
 */
@Component
public class MyRepository {

    public MyRepository() {
    }

    public void getInfo() {
        System.out.println("Get info from Repository!");
    }
}
