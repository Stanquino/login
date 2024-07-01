package com.jsp.login.controles;

import com.jsp.login.models.Producto;
import com.jsp.login.sevices.LoginServic;
import com.jsp.login.sevices.LoginServiceImplement;
import com.jsp.login.sevices.ProductoService;
import com.jsp.login.sevices.ProductoServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productosServlet","/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service= new ProductoServiceImplement();
        List<Producto> productos = service.listar();
        resp.setContentType("text/html; charset=UTF-8");
        // Traigo los datos de mi sesión
        LoginServic auth = new LoginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);
        boolean isLoggedIn = usernameOptional.isPresent(); // Verifica si el usuario ha iniciado sesión
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Productos</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
            out.println("<style>");
            out.println("body { background-color: #515151; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1 class=\"my-4 text-white\">Listado de productos</h1>");
            if(isLoggedIn){
                out.println("<div class=\"alert alert-primary\" role=\"alert\">¡Hola "+  usernameOptional.get() + " bienvenido!</div>");
            }
            out.println("<table class=\"table\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">Nombre</th>");
            out.println("<th scope=\"col\">Descripción</th>");
            if (isLoggedIn) {
                out.println("<th scope=\"col\">Precio</th>");
            }
            out.println("<th scope=\"col\">Categoría</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>"+ p.getNombre() + "</td>");
                out.println("<td>" + p.getDescripcion() + "</td>");
                if (isLoggedIn) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                }
                out.println("<td>" + p.getCategoria() + "</td>");
                out.println("</tr>");
            });

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
