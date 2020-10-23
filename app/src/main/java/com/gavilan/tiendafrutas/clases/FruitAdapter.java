package com.gavilan.tiendafrutas.clases;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gavilan.tiendafrutas.DetalleFrutaActivity;
import com.gavilan.tiendafrutas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolderDatos> {

    ArrayList<Fruta> frutas;

    public FruitAdapter(ArrayList<Fruta> frutaArrayList){
        frutas = frutaArrayList;
    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FruitAdapter.ViewHolderDatos holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetalleFrutaActivity.class);
                Fruta f = frutas.get(position);
                intent.putExtra("frutaObjeto", f);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.CargarFruta(frutas.get(position));
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imgFruta;
        TextView txtNombre, txtKilo, txtMayor;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            imgFruta = itemView.findViewById(R.id.imgFruta);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtKilo = itemView.findViewById(R.id.txtKilo);
            txtMayor = itemView.findViewById(R.id.txtMayor);
        }

        public void CargarFruta(Fruta f){
            txtNombre.setText(f.getNombre());
            txtMayor.setText("Valor x mayor :$"+f.getValorMayor());
            txtKilo.setText("Valor x kilo :$"+f.getValorKilo());
            switch ( f.getNombre() ){
                case "Manzana":
                    Picasso.get().load(R.drawable.apple).into(imgFruta);
                    break;
                case "Naranja":
                    Picasso.get().load(R.drawable.orange).into(imgFruta);
                    break;
                case "Lima":
                    Picasso.get().load(R.drawable.lime).into(imgFruta);
                    break;
                case "Arandano":
                    Picasso.get().load(R.drawable.blueberry).into(imgFruta);
                    break;
                case "Cereza":
                    Picasso.get().load(R.drawable.cherry).into(imgFruta);
                    break;
                case "Mango":
                    Picasso.get().load(R.drawable.mango).into(imgFruta);
                    break;
                case "Melón":
                    Picasso.get().load(R.drawable.melon).into(imgFruta);
                    break;
                case "Granada":
                    Picasso.get().load(R.drawable.pomegranate).into(imgFruta);
                    break;
                case "Frambuesa":
                    Picasso.get().load(R.drawable.raspberry).into(imgFruta);
                    break;
                case "Frutilla":
                    Picasso.get().load(R.drawable.strawberry).into(imgFruta);
                    break;
                case "Mandarina":
                    Picasso.get().load(R.drawable.tangerine).into(imgFruta);
                    break;
            }

        }
    }
}
