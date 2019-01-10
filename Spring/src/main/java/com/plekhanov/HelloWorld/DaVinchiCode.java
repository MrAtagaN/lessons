package com.plekhanov.HelloWorld;

import org.springframework.stereotype.Component;

/**
 * Created by AtagaN on 11.01.2019.
 */

@Component
public class DaVinchiCode implements Book{

    public void read() {
        System.out.println("Read book DaVinchiCode");
    }
}
