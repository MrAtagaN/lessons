package com.plekhanov.service;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Проверка на исключения
 */
public class ExpectException {

    @Test
    public void test1() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {new ArrayList().get(0); });
        assertEquals("Index: 0, Size: 0", exception.getMessage());
    }


}
