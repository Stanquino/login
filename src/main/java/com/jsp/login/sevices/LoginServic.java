package com.jsp.login.sevices;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginServic {
    //obtenemos los datos del usuario
    Optional<String> getUserName(HttpServletRequest request);
}
