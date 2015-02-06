package com.example.tarde.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.example.tarde.dialogos.R.id.*;


public class MainActivity extends ActionBarActivity {
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);


        builder.setTitle("Advertencia")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Se acepto", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

        View actividad = findViewById(btActividad);
        actividad.setOnClickListener((View.OnClickListener) this);

        View fragmento = findViewById(btFragmento);
        fragmento.setOnClickListener((View.OnClickListener) this);

        View personalizado = findViewById(btPersonalizado);
        personalizado.setOnClickListener((View.OnClickListener) this);


        View seleccionMultiple = findViewById(btSeleccionMultiple);
        seleccionMultiple.setOnClickListener((View.OnClickListener) this);




    }

    @Override
    protected Dialog onCreateDialog(int id) {



        return super.onCreateDialog(id);
    }


public void onClick(View v){

    switch (v.getId()){

        case btActividad:
            showDialog(1);
            break;
        case btFragmento:
            AdvertenciaDialogFragment dialogFragment = new AdvertenciaDialogFragment();
           dialogFragment.show(getFragmentManager(), "Dialogo");

            break;
        case btPersonalizado:

            PersonalizadoDialogFragment personalizadoFragment = new PersonalizadoDialogFragment();
            personalizadoFragment.show(getFragmentManager(), "Dialogo");

            break;

        case btSeleccionMultiple:
            break;
    }
}






}
