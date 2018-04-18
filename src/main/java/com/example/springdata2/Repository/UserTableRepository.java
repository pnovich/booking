package com.example.springdata2.Repository;

import com.example.springdata2.Entities.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTableRepository extends JpaRepository<UserTable,Long>{
}
