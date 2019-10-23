package com.example.mercanddo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Listado(View view){
        Intent Listado= new Intent(this, Listado.class);
        startActivity(Listado);
    }

    public void Historial(View view){
        Intent Historial= new Intent(this, Historial.class);
        startActivity(Historial);
    }

    public void Home(View view){
        Intent Home= new Intent(this, MainActivity.class);
        startActivity(Home);
    }
}
