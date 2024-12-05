package com.malb.maze.db;

import com.malb.maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAOInMemory {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Room getRoom(int id){
        String sql = "SELECT * FROM rooms WHERE id = ?";
        Room room = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Room.class)
        );

        return room;
    }

}
