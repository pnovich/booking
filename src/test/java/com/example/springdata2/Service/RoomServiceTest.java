package com.example.springdata2.Service;

//import com.example.springdata2.Repository.UserTableRepository;

import com.example.springdata2.Entities.Category;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Repository.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository roomRepository;

    @Test
    public void getByIdTest(){
        Room room = new Room();
        Category category = new Category(1,"r",5,10);
        room.setCategory(category);
        Mockito.when(roomRepository.findOne((long)1)).thenReturn(room);
        assertThat(roomService.findRoom((long)1).getCategory()).isEqualTo(room.getCategory());
    }

    @Test
    public void getAllRoomsTest(){
        Category category1 = new Category(1,"r",5,10);
        Category category2 = new Category(1,"r",5,10);
        Room room1 = new Room();
        room1.setCategory(category1);
        Room room2 = new Room();
        room1.setCategory(category2);
        List<Room> boockList = new ArrayList<>();
        boockList.add(room1);
        boockList.add(room2);

        Mockito.when(roomRepository.findAll()).thenReturn(boockList);
        assertThat(roomService.getAll()).isEqualTo(boockList);
    }



}
