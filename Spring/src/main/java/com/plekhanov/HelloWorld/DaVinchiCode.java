package com.plekhanov.HelloWorld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by AtagaN on 11.01.2019.
 */

@Component
public class DaVinchiCode implements Book{

    @Value("${name}")// из проперти
    String author;

    @Value("#{2}")
    String coment;

    public void read() {
        System.out.println("Read book DaVinchiCode. Author - "+ author + coment);
    }
}
