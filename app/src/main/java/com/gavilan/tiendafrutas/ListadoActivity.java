package com.gavilan.tiendafrutas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.gavilan.tiendafrutas.clases.FruitAdapter;
import com.gavilan.tiendafrutas.clases.Fruta;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        recyclerView = findViewById(R.id.recyclerView);


        ArrayList<Fruta> listaFruta = new ArrayList<>();
        listaFruta.add(new Fruta(1,"Naranja",500,400));
        listaFruta.add(new Fruta(2,"Arandano",1000,900));
        listaFruta.add(new Fruta(3,"Cereza",1000,850));
        listaFruta.add(new Fruta(4,"Lima",850,700));
        listaFruta.add(new Fruta(5,"Mango",1200,1000));
        listaFruta.add(new Fruta(6,"Melón",1500,1300));
        listaFruta.add(new Fruta(7,"Manzana",650,400));
        listaFruta.add(new Fruta(8,"Granada",2000,1500));
        listaFruta.add(new Fruta(9,"Frambuesa",2000,1800));
        listaFruta.add(new Fruta(10,"Frutilla",1000,850));
        listaFruta.add(new Fruta(11,"Mandarina",800,650));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FruitAdapter fruitAdapter = new FruitAdapter(listaFruta);

        recyclerView.setAdapter(fruitAdapter);


    }
}