package com.example.tarde.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tarde on 04/02/2015.
 */
public class SeleccionMultipleDialogFragment extends DialogFragment {

    private AlertDialog.Builder builder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creamos los arrays que me pide el metodo MultichoiseItems

       final String[] valores={"Rojo","Azul","Verde"};
      final  boolean[] seleccionados={true, false, true};


        builder = new AlertDialog.Builder(getActivity());


        builder.setMultiChoiceItems(valores, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {


            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                seleccionados[which]=isChecked;
                String resultado="";
                for(int i=0;i<seleccionados.length; i++){

                    if(seleccionados[i]){
                        resultado.concat(valores[i]).concat(";");
                    }

            }

                Toast.makeText(getActivity(), resultado, Toast.LENGTH_LONG).show();
            }
        });


    }

        protected Dialog onCreateDialog(int id) {

            return builder.create();
        }
    }