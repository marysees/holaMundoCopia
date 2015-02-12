package com.example.tarde.googlemaps;

import java.io.Serializable;

/**
 * Created by tarde on 12/02/2015.
 */
public class Terremoto implements Serializable {

    private String titulo;
    private float magnitud, longitud, latitud;


    @Override
    public String toString() {
        return "Terremoto{" +
                "titulo='" + titulo + '\'' +
                ", magnitud=" + magnitud +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(float magnitud) {
        this.magnitud = magnitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public Terremoto(String titulo, float magnitud, float longitud, float latitud) {

        this.titulo = titulo;
        this.magnitud = magnitud;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}
