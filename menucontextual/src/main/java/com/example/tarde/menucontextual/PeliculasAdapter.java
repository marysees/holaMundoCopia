package com.example.tarde.menucontextual;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tarde on 03/02/2015.
 */
public class PeliculasAdapter extends BaseAdapter {
    private final Activity contexto;
    private final int layout;
    private final List<Pelicula> listado;


    public PeliculasAdapter(Activity contexto, int resLayout, List<Pelicula> listado) {
        this.contexto=contexto;
        this.layout=resLayout;
        this.listado=listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int position) {
        return listado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void addPelicula(Pelicula pelicula){
        listado.add(pelicula);
        //notifica de los cambios que se producen
        notifyDataSetChanged();
    }

    public List<Pelicula> getListado(){
        return listado;
    }

    public void removePelicula(int position){
        listado.remove(position);
        //notifica de los cambios que se producen
        notifyDataSetChanged();
    }
    public void editPelicula(int position, Pelicula newPelicula ){
        Pelicula oldPelicula = listado.get(position);
        oldPelicula.setActores(newPelicula.getActores());
        oldPelicula.setAño(newPelicula.getAño());
        oldPelicula.setTitulo(newPelicula.getTitulo());
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pelicula pelicula=listado.get(position);
        PeliculaViewHelper peliculaViewHelper;

    //ahorra la creacion de objetos de tipo View, para repintados del AdapterView
    if(convertView == null){
        //si es nulo necesito inflar

        convertView = contexto.getLayoutInflater().inflate(layout, null);


        peliculaViewHelper= new PeliculaViewHelper();

        peliculaViewHelper.actores=(TextView) convertView.findViewById(R.id.actores);
        peliculaViewHelper.año=(TextView) convertView.findViewById(R.id.año);
        peliculaViewHelper.titulo=(TextView) convertView.findViewById(R.id.titulo);


        convertView.setTag(peliculaViewHelper);

    }
        else{
            peliculaViewHelper=(PeliculaViewHelper) convertView.getTag();
        }

        peliculaViewHelper.titulo.setText(pelicula.getTitulo());
        peliculaViewHelper.año.setText(String.valueOf(pelicula.getAño()));
        peliculaViewHelper.actores.setText(pelicula.getActores().toString());

        return convertView;
    }

    //clase para mantener referencias y hacer el findViewById de cada modificacion
    class PeliculaViewHelper{
        TextView titulo;
        TextView año;
        TextView actores;
    }


}
