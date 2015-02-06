package com.example.tarde.serviciolocal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MainService extends Service {
    public MainService() {
    }


    //Metodos que responden a eventos que se producen desde el cliente Start, stop, Bind
    //start
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Arrancado el servicio", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
    //bind
    @Override
    public IBinder onBind(Intent intent) {
        //este metodo esta destinado a recibir una intencion y a devolver un objeto
        // IBinder( objeto intercambiado entre el cliente y el servidor que proporciona
        // al cliente la interfaz de uso)


        MainBinder binder= new MainBinder(this);
    return binder;

    }

    //Desenlazar
     public  boolean onUnbind(Intent intent){
         Toast.makeText(this,"Desenlazado el servicio", Toast.LENGTH_LONG).show();

         return super.onUnbind(intent);
     }

    //stop
    @Override
    public void onDestroy() {
        Toast.makeText(this,"Destruido el servicio", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

//metodoPublicoAccesibleDesdeElCliente() a traves del binder tenemos acceso a las funcionalidades del servicio
    public void  saludo(){
        Toast.makeText(this,"Hola Mundo", Toast.LENGTH_LONG).show();
    }


}
