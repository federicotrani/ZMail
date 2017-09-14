package com.example.ftrani.zmail.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ftrani.zmail.R;

public class MensajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();

        TextView txtAsunto = (TextView) findViewById(R.id.txtAsunto);
        TextView txtRemitente = (TextView) findViewById(R.id.txtMensajeRemitente);
        TextView txtMensaje  = (TextView) findViewById(R.id.txtMensajeContenido);

        txtAsunto.setText(extras.getString("KEY_ASUNTO"));
        txtRemitente.setText(extras.getString("KEY_REMITENTE") + " - " + extras.getString("KEY_EMAIL"));
        txtMensaje.setText(extras.getString("KEY_MENSAJE"));


    }
}
