package com.example.tarde.fragmentosdinamicos;

import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //iniciamos una transacion
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        //añadimos un fragmento
        tx.add(R.id.contenedor, new BuscadorFragment(),"");

            //consolidamos el cambio realizado
        tx.commit();

    }


}
