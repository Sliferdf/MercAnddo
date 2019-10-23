package com.example.mercanddo.Model;

import java.util.List;

public class PeticionesInternas {

    public String Nombre;
    public String RutaImagen;
    public List<Items> Ítems;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRutaImagen() {
        return RutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        RutaImagen = rutaImagen;
    }

    public List<Items> getÍtems() {
        return Ítems;
    }

    public void setÍtems(List<Items> ítems) {
        Ítems = ítems;
    }
}
