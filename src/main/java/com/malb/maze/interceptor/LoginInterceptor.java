package com.malb.maze.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Verificar si el usuario está logueado
        Object user = request.getSession().getAttribute("user");

        // Si no hay usuario en la sesión, redirigir al login
        if (user == null) {
            response.sendRedirect("/login");
            return false; // Detener la ejecución del manejador (handler)
        }

        return true; // Continuar con la ejecución del manejador
    }
}
