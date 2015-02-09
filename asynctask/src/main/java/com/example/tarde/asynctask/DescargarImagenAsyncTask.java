package com.example.tarde.asynctask;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tarde on 04/02/2015.
 */
public class DescargarImagenAsyncTask extends AsyncTask<String, Integer, Bitmap>{
    private ProgressDialog progreso;
    private ImageView destino;


    public DescargarImagenAsyncTask(ProgressDialog progreso, ImageView destino) {
        this.progreso = progreso;
        this.destino=destino;
    }

    //unico metodo que se ejecuta en el hilo secundario
    @Override
    protected Bitmap doInBackground(String... params) {
        //Realizar la tarea de larga duracion
        //Lo que queremos es descargar una imagen de una url y procesarla para convertirla en un Bitmap
        //creamos el objeto url

        try {
            URL url = new URL(params[0]);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            //vamos obteneido los bits (hay que darle el tamaño que se obtiebe con el metodo getContentLength)

            int tamañoImagen=con.getContentLength();

            byte[] imagen= new byte[tamañoImagen];
            //creamos el buffer
            byte[] buffer= new byte[1024];
            //obtenemos el fichero de la imagen
            InputStream is = con.getInputStream();

            //ejecutamos el bucle de lectura, En cada iteracion leemos 10245 bytes

            for(int bytesTotalesLeidos=0; bytesTotalesLeidos <tamañoImagen; ){
                int bytesLeidos= is.read(buffer);

                System.arraycopy(buffer, 0, imagen, bytesTotalesLeidos ,bytesLeidos);

                bytesTotalesLeidos+= bytesLeidos;
                //entero que necesito pasarle al progreso que automaticamente se pasa al value del metodo onProgressupdate
                publishProgress(bytesTotalesLeidos*100/tamañoImagen);

            }
            //una vez leidos todos los bytes de la imagen creamos y devolvemos el bitmap

            return BitmapFactory.decodeByteArray(imagen,0, tamañoImagen);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    //Metodos que se ejecutan en el h8ilo principal para poder usar los objetos en el hilo principal
    //para que salgan automaticos ir a code override metodos

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //aqui solamente iniciamos el objeto ProgressDialog para poder reutilizarlo
        progreso.setProgress(0);
        //mostramos el progreso
        progreso.show();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        //controlamos el null del metodo doInBackground
        if (bitmap !=null){
            //pintamos la imagen en el imagenview del hilo principal
            destino.setImageBitmap(bitmap);
        }

        //ocultamos la barra de progreso
        progreso.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progreso.setProgress(values[0]);

    }

}
