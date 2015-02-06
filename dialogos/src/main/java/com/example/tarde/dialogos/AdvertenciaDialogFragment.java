package com.example.tarde.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by tarde on 04/02/2015.
 */
public class AdvertenciaDialogFragment extends DialogFragment {

    private AlertDialog.Builder builder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       this.builder = new AlertDialog.Builder(getActivity());


       this.builder.setTitle("Advertencia")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Se acepto", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

            }

    protected Dialog onCreateDialog(int id) {

        return builder.create();
    }


}
