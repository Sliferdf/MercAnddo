package com.example.mercanddo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercanddo.Model.Items;
import com.example.mercanddo.Model.ItemsTiendas;
import com.example.mercanddo.Model.PeticionesInternas;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder>{

    private PeticionesInternas dataset;
    private ArrayList<ItemsTiendas> dataset2;

    public ProductosAdapter() {
        dataset = new PeticionesInternas();
        dataset2 = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tabla_productos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PeticionesInternas p =dataset;
        holder.nombreProducto.setText(p.getNombre());
        /*holder.tamañoProducto.setText(i.getTamaño());
        holder.nombreProducto.setText(i.getProducto());
        holder.unidadProducto.setText(""+iT.getPrecio());*/
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void adicionarProductos(PeticionesInternas peticionesInternas) {
        dataset= peticionesInternas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoProducto;
        private TextView nombreProducto;
        private TextView tamañoProducto;
        private TextView precioProducto;
        private TextView unidadProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoProducto = itemView.findViewById(R.id.imgProducto2);
            nombreProducto = itemView.findViewById(R.id.datosNombre2);
            tamañoProducto = itemView.findViewById(R.id.datosTamaño2);
            precioProducto = itemView.findViewById(R.id.datosPrecio2);
            unidadProducto = itemView.findViewById(R.id.unidadProducto);
        }
    }
}
