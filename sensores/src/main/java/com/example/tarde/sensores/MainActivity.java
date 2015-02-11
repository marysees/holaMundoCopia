package com.example.tarde.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements SensorEventListener{
    public SensorManager sensormanager;
    public Sensor defaultSensorMagneticField, defaultSensorAcelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensormanager= (SensorManager) getSystemService(SENSOR_SERVICE);


      defaultSensorAcelerometro= sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         defaultSensorMagneticField = sensormanager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }


    @Override
    protected void onResume() {
        super.onResume();
               //registrar sensores
        sensormanager.registerListener(this, defaultSensorAcelerometro,sensormanager.SENSOR_DELAY_NORMAL);
        sensormanager.registerListener(this, defaultSensorMagneticField,sensormanager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //apagaMOS LOS SENSORES
        sensormanager.unregisterListener(this,defaultSensorAcelerometro );
        sensormanager.unregisterListener(this,defaultSensorMagneticField );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //event.accuracy;
        float[] values= event.values;
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
                Toast.makeText(this, "Acelerometro: " + values[0] + " " + values[1] + " " + values[2], Toast.LENGTH_LONG).show();

            }else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                Toast.makeText(this, "Campo Magnetico: " + values[0] + " " + values[1] + " " + values[2], Toast.LENGTH_LONG).show();
            }
        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
