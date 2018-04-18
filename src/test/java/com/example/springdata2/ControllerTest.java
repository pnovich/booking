package com.example.springdata2;


import com.example.springdata2.Entities.Boocking;
import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Service.BoockingService;
import com.example.springdata2.Service.RoomService;
import com.example.springdata2.Service.UserTableService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserTableService userTableService;


    @Mock
    private RoomService roomService;


    @Mock
    private BoockingService boockingService;

    @InjectMocks
    private Controller controller;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
//                .addFilters(new CORSFilter())
                .build();
    }

    @Test
    public void test_create_user_success() throws Exception {
        UserTable user = new UserTable();
        user.setId(2);
        user.setUserName("tttt");
        when(userTableService.createUser(user)).thenReturn(user);
        mockMvc.perform(
                post("/createuser/tttt")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(asJsonString(user)))
                .andExpect(status().isOk());

    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
