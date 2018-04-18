package com.example.springdata2.Service.impl;

import com.example.springdata2.Entities.UserTable;
import com.example.springdata2.Repository.UserTableRepository;
import com.example.springdata2.Service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTableServiceImpl implements UserTableService {
    @Autowired
    UserTableRepository userTableRepository;

    @Override
    public UserTable findUserTable(long id){ return userTableRepository.findOne(id);}
    @Override
    public UserTable createUser(UserTable userTable){

        return userTableRepository.save(userTable);
    }



}
