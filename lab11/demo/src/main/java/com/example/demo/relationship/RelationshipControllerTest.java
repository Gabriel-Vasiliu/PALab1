package com.example.demo.relationship;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RelationshipControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getRelationshipList() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/relationship")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
