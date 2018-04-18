package com.example.springdata2.Service.impl;

import com.example.springdata2.Entities.Boocking;
import com.example.springdata2.Entities.Category;
import com.example.springdata2.Entities.Room;
import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Repository.BoockingRepository;
import com.example.springdata2.Repository.RoomRepository;
import com.example.springdata2.Repository.UserTableRepository;
import com.example.springdata2.Service.BoockingService;
import com.example.springdata2.Service.RoomService;
import com.example.springdata2.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;


@Service
public class BoockingServiceImpl implements BoockingService {
    @Autowired
    private BoockingRepository boockingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserTableRepository userTableRepository;
    @Autowired
    private RoomService roomService;

    @Override
    public List<Boocking> getAll(){
      return boockingRepository.findAll();
    }
    @Override
    public Boocking findBooking(long id){ return boockingRepository.findOne(id);}
    @Override
    public boolean checkDate(Boocking boocking, String date1, String date2){
        boolean dateIsFree = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        java.time.LocalDate ld1 = boocking.getDate1();
        java.time.LocalDate ld2 = boocking.getDate2();
        java.time.LocalDate newd1 = LocalDate.parse(date1, formatter);
        java.time.LocalDate newd2 = LocalDate.parse(date2, formatter);
        System.out.println(ld1);
        System.out.println(ld2);
        System.out.println(newd1);
        System.out.println(newd2);
        if ((newd2.isAfter(ld1))&(newd1.isBefore(ld2))) dateIsFree = false;
        return dateIsFree;

    }
    @Override
    public Boocking createBoockingByString(long userId,long roomId, String date1,String date2, boolean ad){
        Boocking boocking = new Boocking();
        boocking.setUserTable(userTableRepository.findOne(userId));
        boocking.setDate1(date1);
        boocking.setDate2(date2);
        boocking.setAdditional(ad);
        boocking.setRoom(roomRepository.findOne(roomId));
        boolean free = roomService.roomIsFree(roomId,date1,date2);
        Boocking a = new Boocking();
        if (free)
            {
            a = boockingRepository.save(boocking);
            System.out.println("bookig is ok");
        }
        else
            {
            System.out.println("booking is not ok");
            a = null;
        }
        return a;
    }
    @Override
    public long getBoockingPrice(long userId){
        Boocking boocking = new Boocking();
        UserTable userTable =new UserTable();
        userTable = userTableRepository.findOne(userId);
        boocking = userTable.getBoocking();
        Category category = boocking.getRoom().getCategory();
        long price = category.getCategoryPrice();
        if (boocking.isAdditional())  price = price + category.getAddPrice();
        return price;
    }

}
