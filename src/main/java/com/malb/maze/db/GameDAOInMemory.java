package com.malb.maze.db;

import com.malb.maze.model.Game;
import com.malb.maze.model.Score;
import com.malb.maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameDAOInMemory {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Score> getScoresByGameId(Game game){
        List<Score> scores;
        String sql = "SELECT * FROM scores WHERE idgames = ?";
        scores = jdbcTemplate.query(sql, new Object[]{game},
                new BeanPropertyRowMapper<>(Score.class));

        return scores;
    }
}
