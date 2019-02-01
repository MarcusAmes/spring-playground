package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void calculateTest() throws Exception {
        RequestBuilder request = get("/math/calculate?x=9&y=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("9 + 5 = 14"));
    }

    @Test
    public void calculateMultiplyTest() throws Exception {
        this.mvc.perform(get("/math/calculate?x=4&y=3&operation=multiply"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 3 = 12"));
    }

    @Test
    public void calculateDivideTest() throws Exception {
        this.mvc.perform(get("/math/calculate?x=6&y=3&operation=divide"))
                .andExpect(status().isOk())
                .andExpect(content().string("6 / 3 = 2"));
    }

    @Test
    public void calculateSubtractTest() throws Exception {
        this.mvc.perform(get("/math/calculate?x=3&y=3&operation=subtract"))
                .andExpect(status().isOk())
                .andExpect(content().string("3 - 3 = 0"));
    }

    @Test
    public void calculateSumTest() throws Exception {
        this.mvc.perform(post("/math/sum?n=3&n=4&n=2&n=10"))
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 4 + 2 + 10 = 19"));
    }
}