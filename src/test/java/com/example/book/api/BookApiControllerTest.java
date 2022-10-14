package com.example.book.api;

import com.example.book.repository.entity.book.CreateBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /* code a executer avant les tests */
    @BeforeEach
    void setUp() {
        System.out.println("set up");
    }
    /* code a executer apres les tests */
    @AfterEach
    void tearDown() {
        System.out.println("teardown");
    }

    @Test
    void getAllBooks() throws Exception {
        mockMvc.perform(get("/api/books")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].rating").isNumber());
    }


    @Test
    void CreateBook() throws Exception {

        CreateBook createBookDTO = new CreateBook();
        createBookDTO.setName("livre 1");
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(createBookDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/books").contentType(MediaType.APPLICATION_JSON)
                .content(data).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}