package com.personal.usersignup.auth.infrastructure.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.usersignup.auth.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper MAPPER = new ObjectMapper();

    @Nested
    class SignUpUserUseCasesMock {

        @Test
        void user_sign_in_app() throws Exception {
            UserRegistration user = new UserRegistration(
                    "fernando@gmail.com",
                    "fernando.perera",
                    "MyPassW03R"
            );
            UserDefinition expectedUserDefinition = new UserDefinition(
                    "fernando@gmail.com",
                    "fernando.perera"
            );

            MvcResult result = mockMvc.perform(post("/auth/sign_up")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(asJsonString(user)))
                    .andExpect(status().isCreated())
                    .andReturn();
            UserDefinition registeredUserDefinition = jsonToObject(
                    UserDefinition.class,
                    result.getResponse().getContentAsString()
            );

            assertEquals(expectedUserDefinition, registeredUserDefinition);
        }

    }

    private String asJsonString(Object object) throws JsonProcessingException {
        return MAPPER.writeValueAsString(object);
    }

    private <T> T jsonToObject(Class<T> clazz, String jsonString) throws JsonProcessingException {
        return MAPPER.readValue(jsonString, clazz);
    }

}