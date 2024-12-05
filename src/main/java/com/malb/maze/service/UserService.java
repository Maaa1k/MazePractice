package com.malb.maze.service;

import com.malb.maze.db.UserDAOInMemory;
import com.malb.maze.model.User;
import com.malb.maze.utils.PasswordHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAOInMemory userRepository;

    @Autowired
    public UserService(UserDAOInMemory userRepository) {
        this.userRepository = userRepository;
    }

    // Registrar un usuario
    public void registerUser(User user) {
        // Hash de la contraseña
        String hashedPassword = PasswordHashUtil.hashPassword(user.getPassword());
        user.setPassword(hashedPassword); // Establece la contraseña encriptada

        // Guarda el usuario en la base de datos
        userRepository.saveUser(user);
    }

    // Buscar un usuario por nombre de usuario
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public boolean checkUser(String username){
        return  userRepository.checkUser(username);
    }
    // Obtener todos los usuarios
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
