package com.malb.maze.db;

import com.malb.maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;

@Repository
public class UserDAOInMemory implements UserDAO {

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
        Object[] args = {username};
        User user = jdbcTemplate.queryForObject(sql, args,
                new BeanPropertyRowMapper<>(User.class));

        return Optional.ofNullable(user); // Si existe un usuario, lo devuelve, sino devuelve Optional.empty()
    }

    public boolean checkUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        Object[] args = {username};

        try {
            // Intenta buscar el usuario
            User user = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(User.class));
            return false; // Usuario encontrado, retornar falso
        } catch (EmptyResultDataAccessException e) {
            // No se encontró al usuario
            return true; // Usuario no existe, retornar verdadero
        } catch (DataAccessException e) {
            // Otro error con la base de datos
            throw new RuntimeException("Error al comprobar el usuario", e);
        }
    }


    // Método para obtener todos los usuarios
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
