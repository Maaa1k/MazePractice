package com.malb.maze.db;

import com.malb.maze.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsername(String username);
    boolean checkUser(String username);
}
