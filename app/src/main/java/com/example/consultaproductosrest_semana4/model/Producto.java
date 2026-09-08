package com.example.consultaproductosrest_semana4.model;

import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String nombre;

    @SerializedName("price")
    private double precio;

    @SerializedName("category")
    private String categoria;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}