package com.malb.maze.service;

import com.malb.maze.db.RoomDAOInMemory;
import com.malb.maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomDAOInMemory roomRepository;

    @Autowired
    public RoomService(RoomDAOInMemory roomRepository) {
        this.roomRepository = roomRepository;
    }


    public Room getRoom(int id){
        return roomRepository.getRoom(id);
    }
}
