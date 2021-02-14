package com.plekhanov;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.stream.Collector;


public class Main {

    public static void main(String[] args) {
        Sets.immutableEnumSet(Collector.Characteristics.UNORDERED);


        ImmutableMap.<String, String>builder()
                .put("KEY","VALUE")
                .build();
    }
}
