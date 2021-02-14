package com.plekhanov;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;


public class Main {

    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "b", "c");
        List<String> result = givenList.stream()
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));

        List<Integer> list = IntStream.range(0, 9)
                .boxed()
                .collect(ImmutableList.toImmutableList());

        System.out.println(result.getClass());

        Sets.immutableEnumSet(Collector.Characteristics.UNORDERED);


        ImmutableMap.<String, String>builder()
                .put("KEY","VALUE")
                .build();
    }
}
