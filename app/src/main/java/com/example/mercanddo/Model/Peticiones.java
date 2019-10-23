package com.example.mercanddo.Model;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class Peticiones {

    public  JsonObject Datos;

    public JsonObject getDatos() {
        return Datos;
    }

    public void setDatos(JsonObject datos) {
        Datos = datos;
    }
}
