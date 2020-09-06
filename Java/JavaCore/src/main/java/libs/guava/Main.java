package libs.guava;

import com.google.common.collect.ImmutableMap;


public class Main {

    public static void main(String[] args) {

        ImmutableMap.<String, String>builder()
                .put("KEY","VALUE")
                .build();
    }
}
