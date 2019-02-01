package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

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

    @Test
    public void calculateVolumeTest() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void circleAreaTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType((MediaType.APPLICATION_FORM_URLENCODED))
                .param("type", "circle")
                .param("radius", "3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Area is 28.27"));
    }
    @Test
    public void rectangleAreaTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType((MediaType.APPLICATION_FORM_URLENCODED))
                .param("type", "rectangle")
                .param("length", "3")
                .param("width", "5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Area is 15.00"));
    }
    @Test
    public void invalidAreaTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType((MediaType.APPLICATION_FORM_URLENCODED))
                .param("type", "rectangle")
                .param("radius", "3")
                .param("length", "3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }

    @Test
    public void invalidNegativeAreaTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType((MediaType.APPLICATION_FORM_URLENCODED))
                .param("type", "rectangle")
                .param("width", "-3")
                .param("length", "3");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }
}
