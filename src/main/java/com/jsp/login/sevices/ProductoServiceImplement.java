package com.jsp.login.sevices;

import com.jsp.login.models.Producto;
import java.util.Arrays;
import java.util.List;


public class ProductoServiceImplement implements ProductoService{
    @Override
    public List<Producto> listar(){
        //genero mi linsta utilizando el ARRAYS LIST
        return Arrays.asList(new Producto(1,"Laptop","computacion","hp",585.85),
                new Producto(2,"Celular","smarphone","iphone",985.85),
                new Producto(3,"television","computacion","lg",885.85),
                new Producto(4,"teclado","computacion","heltech",35.85));
    }
}
