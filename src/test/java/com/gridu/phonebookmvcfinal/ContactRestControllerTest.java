package com.gridu.phonebookmvcfinal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gridu.phonebookmvcfinal.dto.Contact;
import com.gridu.phonebookmvcfinal.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ContactRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllContactsStatusTest() throws Exception {

        mvc.perform(get("/api/v1/contacts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addContactTest() throws Exception {

        Contact testContact = new Contact(1, "Test", "111111");

        mvc.perform(post("/api/v1/contacts/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testContact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.contactName").value("Test"))
                .andExpect(jsonPath("$.phone").value("111111"));
    }

    @Test
    void addPhoneToContact() throws Exception {

        String contactName = "Test";
        Contact testContact = new Contact(1, contactName, "1");

        mvc.perform(post("/api/v1/contacts/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testContact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.contactName").value("Test"))
                .andExpect(jsonPath("$.phone").value("1"));

        mvc.perform(put("/api/v1/contacts/"+contactName)
                .contentType(MediaType.APPLICATION_JSON)
                .param("newPhone","2"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.phone").value("1 | 2"));
    }
}
