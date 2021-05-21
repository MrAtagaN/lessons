package com.plekhanov.service;


import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class Annotations {

    @EnabledOnOs(OS.WINDOWS)
    @EnabledIfEnvironmentVariable(named = "", matches= "")
    void test() {

    }
}
