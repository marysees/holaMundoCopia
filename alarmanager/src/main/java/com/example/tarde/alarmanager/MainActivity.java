package com.example.tarde.alarmanager;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
//mal esta incompleto

public class MainActivity extends ActionBarActivity {

    public static final String ACTION= "com.example.tarde.alarmanager.RECEIVER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BroadcastReceiver receptor = new BroadcastReceiver() {


           @Override
            public void onReceive(Context context, Intent intent){

               // String saludo= intent.getStringExtra(FuncionalidadRepetidaBroadcastReceiver, EXTRA_DATO);
               Toast.makeText(context, "Hola una y otra vez", Toast.LENGTH_LONG).show();

            }
        };
/*
        IntentFilter interFilter = new IntentFilter();
        AlarManager alarmManager = (AlarManager) getSystemService(ALARM_SERVICE);
        Intent intent= new Intent(this, FuncionalidadRepetidaBroadcastReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setInexactRepeating(AlarManager.RTC_W, 1000,5000, pendingIntent);
*/
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
