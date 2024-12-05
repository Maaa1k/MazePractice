package com.malb.maze.controller;

import com.malb.maze.model.User;
import com.malb.maze.service.UserService;
import com.malb.maze.utils.PasswordHashUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showLoginForm() {
        return "login"; // Archivo Thymeleaf para el formulario de login
    }

    @PostMapping
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        try {
            Optional<User> user = userService.findByUsername(username);
            if (user.isPresent() && PasswordHashUtil.verifyPassword(password, user.get().getPassword())) {
                // Si el usuario y contraseña son correctos
                return "redirect:/dashboard"; // Redirigir a otra página
            } else {
                System.out.println(user.get().getPassword());
                // Credenciales incorrectas
                model.addAttribute("error", "Usuario o contraseña incorrectos.");
                return "login"; // Volver a la página de login
            }
        } catch (Exception e) {
            // Manejar errores inesperados
            model.addAttribute("error", "Ocurrió un error. Inténtalo de nuevo más tarde.");
            return "login"; // Volver a la página de login
        }
    }
}
