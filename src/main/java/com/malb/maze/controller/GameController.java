package com.malb.maze.controller;

import com.malb.maze.model.Room;
import com.malb.maze.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    private  final RoomService roomService;

    public GameController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Método para manejar el GET de /dashboard
    @GetMapping("/dashboard")
    public String showDashboard() {
        Room room = roomService.getRoom(3);
        room.setIdMaze(1);
        room.setItemCoin(0);

        System.out.println("VALUE DE ROOM N: " + room.getN());
        return "dashboard";  // Retorna el nombre de la plantilla (sin la extensión .html)
    }

    // Método para manejar el GET de /dashboard
    @GetMapping("/start")
    public String showStart() {
        // Aquí, Thymeleaf buscará el archivo dashboard.html en src/main/resources/templates
        return "start";  // Retorna el nombre de la plantilla (sin la extensión .html)
    }

}
