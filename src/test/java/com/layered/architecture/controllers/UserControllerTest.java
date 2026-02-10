package com.layered.architecture.controllers;

import com.layered.architecture.persistence.UserRepository;
import com.layered.architecture.persistence.entities.GenderDb;
import com.layered.architecture.persistence.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.*;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    UserRepository userRepository;

    @Captor
    ArgumentCaptor<User> userCaptor;

    MockedStatic<Instant> mockNow;
    MockedStatic<UUID> mockUUID;
    // Create test class instance
    // run method with annotation @BeforeAll
    // --- FOR EACH TEST
    // run method with annotation @BeforeEach
    // run @Test
    // run method with annotation @AfterEach
    // END OF TEST ---
    // run methode with annotation @AfterAll


    @BeforeEach
    public void setupMocks(){

        Clock clock = Clock.fixed(Instant.parse("2026-02-10T14:51:20Z"), ZoneId.of("UTC"));
        Instant fixedNow = Instant.now(clock);

        mockNow = Mockito.mockStatic(Instant.class);
        mockNow.when(Instant::now).thenReturn(fixedNow);

        UUID fixedUUID = UUID.fromString("01c226a5-6f48-4f52-9142-27849b509357");
        mockUUID = Mockito.mockStatic(UUID.class);
        mockUUID.when(UUID::randomUUID).thenReturn(fixedUUID);
    }

    @Test
    public void test() throws Exception {

//        Getting rid of static mocks (because they might impact application)
        // Tests parametrization
        // reducing repeated objects

        String json = """
                    {
                            "fullName": "Joh Doe",
                            "birthDate": "1995-02-25",
                            "gender": "MALE",
                            "email": "test@example.com",
                            "mobile": "017366576657"
                     }
                """;

        mvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("01c226a5-6f48-4f52-9142-27849b509357"));

        Mockito.verify(userRepository, times(1)).save(userCaptor.capture());

        User capturedUser = userCaptor.getValue();

        assertEquals("Joh Doe", capturedUser.getName());
        assertEquals(GenderDb.male, capturedUser.getGender());
        assertEquals("test@example.com", capturedUser.getEmail());
        assertEquals("017366576657", capturedUser.getMobile());
        assertEquals(LocalDate.of(1995, Month.FEBRUARY, 25), capturedUser.getBirthDate());
        assertEquals("01c226a5-6f48-4f52-9142-27849b509357", capturedUser.getUuid().toString());

    }
}