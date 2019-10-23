package com.example.mercanddo.Model;

import java.util.List;

public class Items {

    public String Producto;
    public int Tamaño;
    public String Unidad;
    public String RutaImagen;
    public List<ItemsTiendas> ÍtemsTiendas;

    public int getTamaño() {
        return Tamaño;
    }

    public String getUnidad() {
        return Unidad;
    }

    public String getProducto() {
        return Producto;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public List<ItemsTiendas> getÍtemsTiendas() {
        return ÍtemsTiendas;
    }
}