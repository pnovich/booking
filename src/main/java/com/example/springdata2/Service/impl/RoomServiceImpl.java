package com.example.springdata2.Service.impl;

import com.example.springdata2.Entities.Category;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Entities.Boocking;
import com.example.springdata2.Repository.CategoryRepository;
import com.example.springdata2.Repository.RoomRepository;
import com.example.springdata2.Service.BoockingService;
import com.example.springdata2.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BoockingService boockingService;
    @Override
    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    @Override
    public Room findRoom(long id){ return roomRepository.findOne(id);}
    @Override
    public List<Room> getRoomByCategory(long id){
        Category category = new Category();
        category = categoryRepository.findOne(id);
        List<Room> list1 = roomRepository.findAll();
        List<Room> list2 = new ArrayList<Room>();
        Iterator<Room> it = list1.iterator();
        while (it.hasNext()){
            Room room = new Room();
            room = it.next();
            if (room.getCategory() == category)
                list2.add(room);
        }

        return list2;
    }

    @Override
    public boolean roomIsFree(long roomId, String date1,String date2){
        boolean t = true;
        Room room = roomRepository.findOne(roomId);
        List<Boocking> roomBookingList = room.getBoockingList();
        Iterator<Boocking> it = roomBookingList.iterator();
        while(it.hasNext()) {
            Boocking boocking = new Boocking();
            boocking = it.next();
//            System.out.println(c);
            t = t & boockingService.checkDate(boocking, date1,date2);
        }
        return t;
    }




}
