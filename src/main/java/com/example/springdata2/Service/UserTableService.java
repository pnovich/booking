package com.example.springdata2.Service;

import com.example.springdata2.Entities.UserTable;
import org.springframework.stereotype.Service;


public interface UserTableService {

    UserTable findUserTable(long id);
    UserTable createUser(UserTable userTable);
}
