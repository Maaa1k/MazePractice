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

        try {
            boolean existingUser = userService.checkUser(username);
            if (!existingUser) {
                // Si el usuario ya existe, mostrar el mensaje de error
                model.addAttribute("error", "El nombre de usuario ya está registrado.");
                return "register"; // Volver al formulario de registro con el mensaje de error
            }

            // Crear el objeto User
            User user = new User();
            user.setUsername(username);
            user.setPassword(password); // La contraseña debe ser encriptada en el servicio

            // Registrar el usuario
            userService.registerUser(user);

            return "redirect:/login"; // Redirige al login después del registro exitoso
        } catch (Exception e) {
            // Si ocurre algún error inesperado, mostrar un mensaje genérico
            model.addAttribute("error", "Ocurrió un error durante el registro. Por favor, inténtalo de nuevo.");
            return "register";
        }
    }
}
