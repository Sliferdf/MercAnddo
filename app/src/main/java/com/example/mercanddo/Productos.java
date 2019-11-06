package com.example.mercanddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mercanddo.Interface.LosPreciosApi;
import com.example.mercanddo.Model.Peticiones;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Productos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

    }

    public void Listado(View view){
        Intent Listado= new Intent(this, Listado.class);
        startActivity(Listado);
    }

    public void Historial(View view){
        Intent Historial= new Intent(this, Productos.class);
        startActivity(Historial);
    }

    public void Home(View view){
        Intent Home= new Intent(this, MainActivity.class);
        startActivity(Home);
    }

}
