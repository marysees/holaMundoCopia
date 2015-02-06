package com.example.tarde.asynctask;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
private  ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//creamos un objeto de dialogo y le damos el valor máximo de progreso
       dialog= new ProgressDialog(this);
        dialog.setMax(100);

        //ponemos el estilo de la imagen
    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);


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

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            DescargarImagenAsyncTask asyncTask= new DescargarImagenAsyncTask(dialog, imageView);
            asyncTask.execute("http://static5.bornrichimages.com/cdn2/683/384/91/c/wp-content/uploads/s3/1/2012/05/31/1338467250.jpg");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
