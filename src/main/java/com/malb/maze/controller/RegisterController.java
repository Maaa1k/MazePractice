package com.malb.maze.controller;

import com.malb.maze.model.User;
import com.malb.maze.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Devuelve la vista para el formulario de registro
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model) {

        Optional<User> existingUser = userService.findByUsername(username);
        if (existingUser.isPresent()) {
            // Si el usuario ya existe, mostrar el mensaje de error
            model.addAttribute("error", "El usuario ya existe");
            return "register"; // Volver al formulario de registro con el mensaje de error
        }
        // Crear el objeto User
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // La contraseña no está encriptada todavía


        // Registrar el usuario (la contraseña se encripta en el servicio)
        userService.registerUser(user);

        return "redirect:/login"; // Redirige al login después del registro
    }
}
