package com.malb.maze.db;

import com.malb.maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;

@Repository
public class UserDAOInMemory {

@Autowired
private JdbcTemplate jdbcTemplate;

    // Método para guardar un usuario en la base de datos
    public void saveUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    // Método para encontrar un usuario por nombre
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username},
                new BeanPropertyRowMapper<>(User.class));
        return users.stream().findFirst(); // Si existe un usuario, lo devuelve, sino devuelve Optional.empty()
    }

    // Método para obtener todos los usuarios
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
