package com.example.tarde.servicioremoto;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by tarde on 05/02/2015.
 */
public class SaludadorService extends Service{
    public SaludadorService(){

    }


    @Override
    public IBinder onBind(Intent intent) {
     //ServicioSaludador.Stub stub;
        //stub = new ServicioSaludador.Stub();


        throw  new UnsupportedOperationException("no esta implementado");


    }




}
