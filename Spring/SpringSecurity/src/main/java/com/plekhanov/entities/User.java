package com.plekhanov.entities;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class User implements Serializable {

    private String name = "AtagaN";
    private int age = 30;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
