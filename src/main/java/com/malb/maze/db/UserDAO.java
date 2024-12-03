package com.malb.maze.db;

import com.malb.maze.model.User;

public interface UserDAO {
    User findByUsername(String username);
}
