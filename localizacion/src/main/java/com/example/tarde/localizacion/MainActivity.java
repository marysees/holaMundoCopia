package com.example.tarde.localizacion;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity implements LocationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    //establecemos los criterios de localizacion
        Criteria req = new Criteria();
        //marcamos la precision
        req.setAccuracy(Criteria.ACCURACY_FINE);
        req.setAltitudeRequired(true);
        String bestProvider = locationManager.getBestProvider(req, false);
        Toast.makeText(this,"Proveedor: "+ bestProvider,Toast.LENGTH_SHORT).show();
        List<String> listaProviders = locationManager.getAllProviders();
        Toast.makeText(this, "Lista: "+listaProviders,Toast.LENGTH_SHORT).show();


            //comprobamos si el provider esta habilitado
        if(!locationManager.isProviderEnabled(bestProvider)){

        // si no esta habilitado lo tenemos que activar

            Intent in = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);

            startActivity(in);



        }
        //registrar un locationListener y que nos avise de nuevas lecturas
        locationManager.requestLocationUpdates(bestProvider, 1 * 60 * 1000, 100, this);

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

    //metodos de listener de la localizacion

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this,"Altitud: "+location.getAltitude()+ "Longitud: "+location.getLongitude()+ "Altitud: "+location.getAltitude()
               ,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }



}
