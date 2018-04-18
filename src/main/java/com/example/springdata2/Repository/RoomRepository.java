package com.example.springdata2.Repository;

import com.example.springdata2.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long>{
}
