package com.example.tarde.contentprovide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tarde on 09/02/2015.
 */
public class NoticiasSQLiteOpenHelper extends SQLiteOpenHelper{
    private Context context;

    public NoticiasSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //referencia al contexto para poder recoger los recursos
        this.context=context;
    }


    //Gestion o administracion de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQliteDataBase semejante al Session
        //cramos la base de datos

        ejecutarScript(db, R.array.scriptCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //para controlar las versiones
        switch (oldVersion){
            case 1:
                ejecutarScript(db, R.array.scriptUpgrade_1_3);
                break;

            case 2:
                ejecutarScript(db, R.array.scriptUpgrade_2_3);
                break;


        }




//ejecutamos la consulta
       ejecutarScript(db, R.array.scriptUpgrade);

    }



private void ejecutarScript(SQLiteDatabase db, int resScript){
    //SQliteDataBase semejante al Session
    //cramos la base de datos
    String[] script = context.getResources().getStringArray(resScript);

    //abrimos la conexion
    db.beginTransaction();

    try {
        //actualizamos la BD
        for (String sentencia : script) {
            db.execSQL(sentencia);
        }
        db.setTransactionSuccessful();
    }finally{
        //cerramos la transacion
        db.endTransaction();
    }



}
}