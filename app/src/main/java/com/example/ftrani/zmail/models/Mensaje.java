package com.example.ftrani.zmail.models;

/**
 * Created by ftrani on 5/9/17.
 */

public class Mensaje {
    private String remitente;
    private String email;
    private String asunto;
    private String contenido;
    private String color;

    public Mensaje(String remitente, String email, String asunto, String contenido, String color) {
        this.remitente = remitente;
        this.email = email;
        this.asunto = asunto;
        this.contenido = contenido;
        this.color = color;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
