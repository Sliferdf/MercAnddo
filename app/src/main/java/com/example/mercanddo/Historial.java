package com.example.mercanddo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mercanddo.Interface.LosPreciosApi;
import com.example.mercanddo.Model.Items;
import com.example.mercanddo.Model.ItemsTiendas;
import com.example.mercanddo.Model.Peticiones;
import com.example.mercanddo.Model.PeticionesInternas;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Historial extends AppCompatActivity {

    private TextView textNombre;
    private TextView textTamaño;
    private TextView textPrecio;
    private ImageView imgProduc;
    private static final String TAG = "MERCADO";
    private Context context = Historial.this;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ProductosAdapter productosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        textNombre = findViewById(R.id.datosNombre);
        textTamaño= findViewById(R.id.datosNombre);
        textPrecio = findViewById(R.id.datosNombre);
        imgProduc = (ImageView) findViewById(R.id.imgProducto);
        recyclerView = (RecyclerView) findViewById(R.id.recyclersito);
        productosAdapter = new ProductosAdapter();
        recyclerView.setAdapter(productosAdapter);
        recyclerView.setHasFixedSize(true);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://losprecios.co/tienda/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            getPeticiones();
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

    public void getPeticiones(){

        LosPreciosApi losPreciosApi = retrofit.create(LosPreciosApi.class);

            Call<Peticiones> peticionesCall = losPreciosApi.getPost(new Integer[]{1,2,3,4,5});

            peticionesCall.enqueue(new Callback<Peticiones>() {
                @Override
                public void onResponse(Call<Peticiones> call, Response<Peticiones> response) {
                    Gson gson = new Gson();
                    if (!response.isSuccessful()) {
                        Log.e(TAG, "Error:" + response.errorBody());
                    }
                    Peticiones catag = response.body();
                    JsonObject datos = catag.Datos;
                    String json = gson.toJson(datos);
                    PeticionesInternas peticionesInternas = gson.fromJson(json, PeticionesInternas.class);

                    productosAdapter.adicionarProductos(peticionesInternas);
                    /*textNombre.setText("Nombre de la tiemda: " + peticionesInternas.Nombre + "\n");
                    for (Items i : peticionesInternas.Ítems) {
                        textNombre.append("Nombre Producto : " + i.Producto + " Tamaño: " + i.Tamaño + i.Unidad);
                        //Glide.with(context).load(i.RutaImagen).into(imgProduc);
                        for (ItemsTiendas iT : i.ÍtemsTiendas) {
                            textPrecio.append(" Precio: " + iT.Precio + " \n");
                        }
                    }*/
                }

                @Override
                public void onFailure(Call<Peticiones> call, Throwable t) {
                    textNombre.setText(" onFailure :" + t.getMessage());
                }
            });
    }
}
