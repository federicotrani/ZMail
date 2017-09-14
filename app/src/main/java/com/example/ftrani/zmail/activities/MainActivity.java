package com.example.ftrani.zmail.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ftrani.zmail.adapters.MensajeAdapter;
import com.example.ftrani.zmail.R;
import com.example.ftrani.zmail.models.Mensaje;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_zmail);

        final ArrayList<Mensaje> mensajes = new ArrayList<>();

        //llamo metodo de carga mensajes en array
        this.cargarLista(mensajes);

        ListView listView = (ListView) findViewById(R.id.listaMensajes);

        //asigno adaptador al listview
        listView.setAdapter(new MensajeAdapter(mensajes));

        //implemento listener del evento clic del listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Mensaje mensajeSeleccionado = mensajes.get(i);
                abrirMensaje(mensajeSeleccionado);
            }
        });
    }

    private void abrirMensaje(Mensaje mensajeSeleccionado){
        Intent intent = new Intent(MainActivity.this, MensajeActivity.class);

        intent.putExtra("KEY_ASUNTO",mensajeSeleccionado.getAsunto());
        intent.putExtra("KEY_REMITENTE",mensajeSeleccionado.getRemitente());
        intent.putExtra("KEY_EMAIL",mensajeSeleccionado.getEmail());
        intent.putExtra("KEY_MENSAJE",mensajeSeleccionado.getContenido());


        startActivity(intent);
    }

    private void cargarLista(ArrayList<Mensaje> mensajes){

        //primero mensaje
        mensajes.add(new Mensaje(
                "Ernesto Dominguez",
                "edominguez@gmail.com",
                "Pedido Cotizacion",
                "Este es el cuerpo del mensaje de prueba. Este es el cuerpo del mensaje de prueba. ",
                "#ff4081"
        ));

        //segundo mensaje
        mensajes.add(new Mensaje(
                "Maria Pilar Perez",
                "mperez@gmail.com",
                "Respuesta Solicitud",
                "Integer blandit, orci non feugiat condimentum, nibh tortor dignissim nisi, vel lacinia felis eros sed turpis. Morbi varius semper quam nec tincidunt. Etiam nec suscipit urna. Morbi eget ex magna. Integer fringilla finibus dui, in fringilla augue. Pellentesque gravida pulvinar faucibus. Aliquam iaculis at neque eget molestie. Suspendisse eu purus porta, suscipit metus sed, interdum orci.",
                "#00695c"
        ));

        //tercer mensaje
        mensajes.add(new Mensaje(
                "Eduardo Rodriguez",
                "erodriguez@gmail.com",
                "Consulta",
                "Integer blandit, orci non feugiat condimentum, nibh tortor dignissim nisi, vel lacinia felis eros sed turpis. Morbi varius semper quam nec tincidunt. Etiam nec suscipit urna. Morbi eget ex magna. Integer fringilla finibus dui, in fringilla augue. Pellentesque gravida pulvinar faucibus. Aliquam iaculis at neque eget molestie. Suspendisse eu purus porta, suscipit metus sed, interdum orci.",
                "#3f51b5"
        ));

        //cuarto mensaje
        mensajes.add(new Mensaje(
                "Luis Bacci",
                "lbacci@gmail.com",
                "Datos de Contacto",
                "Integer blandit, orci non feugiat condimentum, nibh tortor dignissim nisi, vel lacinia felis eros sed turpis. Morbi varius semper quam nec tincidunt. Etiam nec suscipit urna. Morbi eget ex magna. Integer fringilla finibus dui, in fringilla augue. Pellentesque gravida pulvinar faucibus. Aliquam iaculis at neque eget molestie. Suspendisse eu purus porta, suscipit metus sed, interdum orci.",
                "#3f51b5"
        ));

    }
}
