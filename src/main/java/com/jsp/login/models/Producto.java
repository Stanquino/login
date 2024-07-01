package com.jsp.login.models;

public class Producto {
    private int idProducto;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precio;

    //Implementamos el constructor
    public Producto() {
    }

    // Constructor que inicializa todos los parámetros
    public Producto(int idProducto, String nombre, String categoria, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Métodos get y set para id
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    // Métodos get y set para nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos get y set para categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Métodos get y set para descripcion
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
}

