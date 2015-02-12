package com.example.tarde.googlemaps;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private static final String EXTRA_TERREMOTO ="terremoto" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
       Terremoto terremoto=  (Terremoto)getIntent().getSerializableExtra(EXTRA_TERREMOTO);
        if(terremoto==null){
            finish();
        }
*/

        //funcionalidad para recoger la intencion en un objeto terremoto

        Terremoto terremoto= new Terremoto("Terremoto en santiago",1.3f, 42.862130f, -8.554f );

        TerremotoMapFragment mapFragment= getFragmentManager().findFragmentById(R.id.mapFragment);

        if (mapFragment== null){
            mapFragment.dibujarTerremoto(terremoto);
        }
        /*Fragment detalleFragment = getFragmentManager().findFragmentById(R.id.detalle);

        if(detalleFragment!=null){
            detalleFragment.dibujarTerremoto(terremoto);
        }*/



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
