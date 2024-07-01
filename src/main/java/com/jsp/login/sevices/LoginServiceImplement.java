package com.jsp.login.sevices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;


public class LoginServiceImplement implements LoginServic{

    @Override
    //creando un metodo para obtener el nombre del usuario
    public Optional<String>getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }

        return Optional.empty();
    }
}
