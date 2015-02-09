package com.example.tarde.menucontextual;

//El menu contextual no salta con un click sino con un pinchado prolongado

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private PeliculasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencia al LV
        ListView listView= (ListView) findViewById((R.id.listView));
        //indicamos que el listview tendra el menu contextual
        registerForContextMenu(listView);

        List<Pelicula> lista = Arrays.asList(
                new Pelicula ("Lo que el viento se llevo", 1939, new String[]{"Viviane Leigth", "Clark Gable"}),
                new Pelicula ("Titanic", 1997, new String[]{"Leonardo Di Caprio", "Kate Wisler"})
        );
        listView.setAdapter(new PeliculasAdapter(this, R.layout.list_item_peliculas, lista));


    }
//de forma análoga a lo que aparece en una activity tenemos los metodos similares pero de ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()){
            case R.id.listView:
                //vamos a escribir en la cabecera algo que represente al item que salga con pulsacion prolongada
                int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
                Adapter adapter = ((AdapterView) v).getAdapter();
                menu.setHeaderTitle(adapter.getItem(position).toString());
                getMenuInflater().inflate(R.menu.menu_listview, menu);
                break;



        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       int position= ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position;
        PeliculasAdapter adapter = (PeliculasAdapter) ((AdapterView) item.getActionView()).getAdapter();
        Pelicula pelicula = (Pelicula) adapter.getItem(position);


        switch (item.getItemId()){
            case R.id.action_add:
            //Logica que da de alta un nuevo elemento
                Intent intent = new Intent(this, NuevaPeliculaActivity.class);
                startActivityForResult(intent,1);

                break;
          case R.id.action_edit:
              //Logica que edita un elemento
              break;
          case R.id.action_delete:
              //Logica que borra un elemento
              adapter.removePelicula(position);
              break;
        }




        return super.onContextItemSelected(item);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Pelicula pelicula = (Pelicula) data.getSerializableExtra("pelicula");
        int position=data.getIntExtra("position",-1);



        this.adapter.addPelicula(pelicula);
    }
}
