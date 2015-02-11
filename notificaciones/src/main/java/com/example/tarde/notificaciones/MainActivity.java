package com.example.tarde.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//incompleto ver el de VICTOR

public class MainActivity extends ActionBarActivity {
    Notification.Builder builder;

    Notification.Builder builderProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //una notificacion se crea a traves de un builder
        builder = new Notification.Builder(this);
        Intent intent= new Intent(this, MainActivity.class);

        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setTicker("Aviso")
                .setSmallIcon(android.R.drawable.ic_menu_camera)
                .setContentTitle("Notificacion de Aviso")
                .setContentText("Descripcion de la notificacion")
                .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_alert)))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_alert))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) ;
        builderProgress= new Notification.Builder(this);
        builderProgress.setProgress(0, 0, true)
        .setContentTitle("Cargando")
        .addAction(android.R.drawable.sym_def_app_icon, "titulo", pendingIntent)
                ;
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
        Notification notificacion = builder.build();
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notificacion) {

            notificationmanager.notify(1, notificacion);

            return true;
        }else if (id == R.id.action_progreso) {
          notificacion = builderProgress.build();
            builderProgress.setProgress(100, 200, false);
             notificationmanager.notify(2, notificacion);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
