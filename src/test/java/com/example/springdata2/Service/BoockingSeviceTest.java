package com.example.springdata2.Service;

import com.example.springdata2.Entities.Boocking;
import com.example.springdata2.Entities.Category;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Repository.BoockingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoockingSeviceTest {

    @Autowired
    private BoockingService boockingService;

    @MockBean
    private BoockingRepository boockingRepository;

    @Test
    public void getByIdTest(){
        Boocking boocking = new Boocking();
        boocking.setId(1);
        boocking.setAdditional(true);
        Mockito.when(boockingRepository.findOne((long)1)).thenReturn(boocking);
        assertThat(boockingService.findBooking((long)1).isAdditional()).isEqualTo(boocking.isAdditional());

    }


}
