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
        // Buscar al usuario por su username
        Optional<User> user = userService.findByUsername(username);

        if (user.isPresent() && PasswordHashUtil.verifyPassword(password, user.get().getPassword())) {
            // Contraseña correcta
            model.addAttribute("user", user);
            return "redirect:/dashboard"; // Página de bienvenida
        }

        // Si las credenciales no coinciden
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }
}
