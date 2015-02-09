package com.example.tarde.tratamientoxml;

import java.util.Date;

/**
 * Created by tarde on 06/02/2015.
 */
public class Terremoto {
   private String id, titulo, link;
   private Date fecha;

 private float latitud, longitud, magnitud;


    public Terremoto() {
        super();
    }

    public Terremoto(String id, String title, String link, Date fecha, float latitud, float longitud, float magnitud) {
        this.id = id;
        this.titulo = title;
        this.link = link;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.magnitud = magnitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(float magnitud) {
        this.magnitud = magnitud;
    }
}
