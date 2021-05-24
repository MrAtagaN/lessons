package com.plekhanov.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class MainControllerTest {

    private static MockMvc mockMvc;

    @BeforeAll
    static void init() {
        MainController mainController = new MainController();
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void mainTest() throws Exception {
        mockMvc.perform(post("/main")
                .contentType(MediaType.APPLICATION_JSON)
                .content("test body"))
                .andDo(print())
                .andExpect(content().string("OK !"))
                .andExpect(status().is(200));
    }
}
