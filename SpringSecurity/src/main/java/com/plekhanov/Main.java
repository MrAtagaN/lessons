package com.plekhanov;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@SpringBootApplication
public class Main {

    public static void main(String[] args) {
       // SpringApplication.run(Main.class, args);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String encode = bCryptPasswordEncoder.encode("admin");
        System.out.println("encode = " + encode);
    }

}
