package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormController.class)
public class FormControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void formTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/comments")
                .contentType((MediaType.APPLICATION_FORM_URLENCODED))
                .param("content", "Firsties!")
                .param("author", "Dwayne");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Dwayne said Firsties!"));
    }
}
