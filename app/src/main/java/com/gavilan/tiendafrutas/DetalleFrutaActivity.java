package com.gavilan.tiendafrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gavilan.tiendafrutas.clases.Fruta;
import com.squareup.picasso.Picasso;

public class DetalleFrutaActivity extends AppCompatActivity {

    private ImageView imgFrutaDetalle;
    private TextView txtNombreDetalle, txtPrecioUnitarioDetalle, txtPrecioMayorDetalle;
    private EditText txtCantidad;
    private Button btnComprar, btnLista;
    private Fruta fruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_fruta);
        // REFERENCIAS
        imgFrutaDetalle = findViewById(R.id.imgFrutaDetalle);
        txtNombreDetalle = findViewById(R.id.txtNombreDetalle);
        txtPrecioUnitarioDetalle = findViewById(R.id.txtPrecioUnitarioDetalle);
        txtPrecioMayorDetalle = findViewById(R.id.txtPrecioMayorDetalle);
        txtCantidad = findViewById(R.id.txtCantidad);
        btnComprar = findViewById(R.id.btnComprar);
        btnLista = findViewById(R.id.btnLista);

        // OnClick botones
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLista = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(intentLista);
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = 0;
                if(txtCantidad.getText().length() == 0){
                    txtCantidad.setError("Ingresa un número");
                }else{
                    cantidad = Integer.parseInt(txtCantidad.getText().toString());

                    if(cantidad == 0){
                        txtCantidad.setError("Ingrese un número mayor que 0");
                    }else if(cantidad < 10){
                        double total = cantidad * fruta.getValorKilo();
                        Toast.makeText(getApplicationContext(),"Total : $"+total,Toast.LENGTH_LONG).show();
                    }else{
                        double total = cantidad * fruta.getValorMayor();
                        Toast.makeText(getApplicationContext(),"Total : $"+total,Toast.LENGTH_LONG).show();
                    }

                }


            }
        });



        // Recibir el inten y obetner los datos que ahí viajan
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            fruta = (Fruta) bundle.get("frutaObjeto");

            txtNombreDetalle.setText(fruta.getNombre());
            txtPrecioUnitarioDetalle.setText("Valor x kilo :$"+fruta.getValorKilo());
            txtPrecioMayorDetalle.setText("Valor x mayor :$"+fruta.getValorMayor());

            switch ( fruta.getNombre() ){
                case "Manzana":
                    Picasso.get().load(R.drawable.apple).into(imgFrutaDetalle);
                    break;
                case "Naranja":
                    Picasso.get().load(R.drawable.orange).into(imgFrutaDetalle);
                    break;
                case "Lima":
                    Picasso.get().load(R.drawable.lime).into(imgFrutaDetalle);
                    break;
                case "Arandano":
                    Picasso.get().load(R.drawable.blueberry).into(imgFrutaDetalle);
                    break;
                case "Cereza":
                    Picasso.get().load(R.drawable.cherry).into(imgFrutaDetalle);
                    break;
                case "Mango":
                    Picasso.get().load(R.drawable.mango).into(imgFrutaDetalle);
                    break;
                case "Melón":
                    Picasso.get().load(R.drawable.melon).into(imgFrutaDetalle);
                    break;
                case "Granada":
                    Picasso.get().load(R.drawable.pomegranate).into(imgFrutaDetalle);
                    break;
                case "Frambuesa":
                    Picasso.get().load(R.drawable.raspberry).into(imgFrutaDetalle);
                    break;
                case "Frutilla":
                    Picasso.get().load(R.drawable.strawberry).into(imgFrutaDetalle);
                    break;
                case "Mandarina":
                    Picasso.get().load(R.drawable.tangerine).into(imgFrutaDetalle);
                    break;
            }
        }else{
            Toast.makeText(getApplicationContext(),"Nada que cargar",Toast.LENGTH_LONG).show();
        }


    }
}