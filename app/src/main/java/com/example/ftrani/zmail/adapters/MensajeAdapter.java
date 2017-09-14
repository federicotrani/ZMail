package com.example.ftrani.zmail.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ftrani.zmail.R;
import com.example.ftrani.zmail.models.Mensaje;

import java.util.ArrayList;

/**
 * Created by ftrani on 6/9/17.
 */

public class MensajeAdapter extends BaseAdapter {

    private ArrayList<Mensaje> mensajes;
    private final int MAX_LARGO_MENSAJE=40;

    public MensajeAdapter(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public int getCount() {
        return mensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return mensajes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View convertView;

        //optimizacion
        if(view==null){
            convertView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_mensajes,parent,false);
        }else{
            convertView = view;
        }

        Mensaje mensaje = (Mensaje) getItem(position);

        TextView txtIcono = convertView.findViewById(R.id.txtIcono);
        TextView txtAsunto = convertView.findViewById(R.id.txtAsunto);
        TextView txtContenido = convertView.findViewById(R.id.txtContenido);

        txtIcono.setText(mensaje.getRemitente().substring(0,1));
        txtIcono.getBackground().setColorFilter(Color.parseColor(mensaje.getColor()), PorterDuff.Mode.SRC);
        //txtIcono.setBackgroundColor(convertView.getResources().getColor(R.color.colorAccent));
        txtAsunto.setText(mensaje.getAsunto());

        if(mensaje.getContenido().length()>MAX_LARGO_MENSAJE){
            txtContenido.setText(mensaje.getContenido().substring(0,MAX_LARGO_MENSAJE));
        }else{
            txtContenido.setText(mensaje.getContenido());
        }

        return convertView;
    }
}
