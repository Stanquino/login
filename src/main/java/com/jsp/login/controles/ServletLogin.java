package com.jsp.login.controles;

import com.jsp.login.sevices.LoginServic;
import com.jsp.login.sevices.LoginServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/Login", "/LoginServlet"})
public class ServletLogin extends HttpServlet {

    final static String username = "admin";
    final static String  password1= "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginServic auth = new LoginServiceImplement();

        Optional<String> usernameOptional = auth.getUserName(req);
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;Charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Servlet</title>");
                out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
                out.println("<style>");
                out.println("body { background-color: red; }");
                out.println(".card { border-radius: 15px; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<div class=\"row justify-content-center mt-5\">");
                out.println("<div class=\"col-md-6\">");
                out.println("<div class=\"card shadow\">");
                out.println("<div class=\"card-body\">");
                out.println("<h1 class=\"card-title text-center text-primary\">¡Bienvenido!</h1>");
                out.println("<h1 class=\"text-center\">Hola " + usernameOptional.get() + ", has iniciado sesión con éxito</h1>");
                out.println("<p class=\"text-center\"><a href='" + req.getContextPath() + "/index.html' class=\"btn btn-primary\">Volver</a></p>");
                out.println("<br>");
                out.println("<p class=\"text-center\"><a href='" + req.getContextPath() + "/logout' class=\"btn btn-danger\">Cerrar sesión</a></p>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }


    //Sobre escribimos el metodo doPost
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtenemos el parametro
        String usersname = req.getParameter("username");
        //Obtenemos el password
        String password = req.getParameter("password");


        if(username.equals(usersname) && password1.equals(password)) {
            //Genero la sesion y obtenemos los paramtros de la sesion
            HttpSession session = req.getSession();
            //Se setaa
            session.setAttribute("username", usersname);
            //Obtenemos los paramtros del context
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");

        }else{
            //Es para verificar si esta autorizado para ingresar al sistema
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No esta autorizado para ingresar al sistema");
        }
    }

}
