package com.malb.maze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    // Método para manejar el GET de /dashboard
    @GetMapping("/dashboard")
    public String showDashboard() {
        // Aquí, Thymeleaf buscará el archivo dashboard.html en src/main/resources/templates
        return "dashboard";  // Retorna el nombre de la plantilla (sin la extensión .html)
    }

    // Método para manejar el GET de /dashboard
    @GetMapping("/start")
    public String showStart() {
        // Aquí, Thymeleaf buscará el archivo dashboard.html en src/main/resources/templates
        return "start";  // Retorna el nombre de la plantilla (sin la extensión .html)
    }

}
