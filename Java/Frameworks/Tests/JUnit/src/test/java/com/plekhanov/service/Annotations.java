package com.plekhanov.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.springframework.test.annotation.DirtiesContext;


/**
 *  {@link DirtiesContext}
 *
 */
public class Annotations {
    @EnabledOnOs(OS.WINDOWS)
    @EnabledIfEnvironmentVariable(named = "", matches= "")
    @DisplayName("описание теста выводимое в IDE")
    void test() {

    }
}
