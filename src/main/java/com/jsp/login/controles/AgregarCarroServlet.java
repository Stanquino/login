package com.jsp.login.controles;

import com.jsp.baseconectar.modelo.Carro;
import com.jsp.baseconectar.modelo.ItemCarro;
import com.jsp.baseconectar.modelo.Producto;
import com.jsp.baseconectar.services.ProductoService;
import com.jsp.baseconectar.services.ProductoServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //aqui se  optiene el id  del producto
        Integer idProducto = Integer.parseInt(req.getParameter("id"));
        ProductoService service = new ProductoServiceImplement();
        Optional<Producto> producto = service.porId(idProducto);
        //generamos una sesion
        if (producto.isPresent()) {
            //solo se muestra cuando esta iniciado sesion
            ItemCarro item = new ItemCarro(1, producto.get());
            //obtenemops la sesion
            HttpSession session = req.getSession();
            Carro carro;
            if (session.getAttribute("carro") == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            }else {
                carro = (Carro) session.getAttribute("carro");
            }
            carro.addItemCarro(item);
        }
        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}
