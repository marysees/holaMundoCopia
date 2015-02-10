package com.example.tarde.contentprovide;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;


public class NoticiasProvider extends ContentProvider {


    public Context context;
    public SQLiteDatabase db;
    public static UriMatcher matcher= new UriMatcher(UriMatcher.NO_MATCH);
    public static final String NOTICIAS_AUTHORITY="com.curso.android.noticias";
    public static final String NOTICIA_ENTIDAD="Noticia";
    public static final String AUTOR_ENTIDAD="Autor";

    public static final int CODE_NOTICIAS=1;
    public static final int CODE_NOTICIA=2;
    public static final int CODE_AUTORES=3;
    public static final int CODE_AUTOR=4;

    public static final String TABLA="NOTICIAS";
    public static final String CAMPO_ID="ID";
    public static final String CAMPO_TITULO="TITULO";
    public static final String CAMPO_DESCRIPCION="DESCRIPCION";
    public static final String CAMPO_CREADOR="CREADOR";
    public static final String CAMPO_LINK="LINK";
    public static final String CAMPO_CONTENIDO="CONTENIDO";
    public static final String CAMPO_FECHA="FECHA_PUBLICACION";




    static{
        //creamos el patron de la URl que queremos localiar
        //content://com.curso.android.noticias/Noticias -> es lo que se aplica a todo el contenido
        matcher.addURI(NOTICIAS_AUTHORITY,NOTICIA_ENTIDAD,CODE_NOTICIAS);
        //content://com.curso.android.noticias/Noticias -> es lo que afecta al item con ID=1
        matcher.addURI(NOTICIAS_AUTHORITY,NOTICIA_ENTIDAD+"/*",CODE_NOTICIA);

        matcher.addURI(NOTICIAS_AUTHORITY,NOTICIA_ENTIDAD,CODE_AUTORES);

        matcher.addURI(NOTICIAS_AUTHORITY,NOTICIA_ENTIDAD+"/#", CODE_AUTOR);

    }

    @Override
    public boolean onCreate() {
        context = getContext();
        NoticiasSQLiteOpenHelper noticiasSQLiteOpenHelper = new NoticiasSQLiteOpenHelper(context, "NoticiasDB.s3db", null, getContext().getResources().getInteger(R.integer.DataBaseVersion));
        db= noticiasSQLiteOpenHelper.getWritableDatabase();
        return true;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch(matcher.match(uri)) {
            case CODE_NOTICIA:
                //para obtener el ultimo elemento del la uri que es el idid
                String id = uri.getLastPathSegment();
                String[] whereArgs={id};
                String whereClause=CAMPO_ID+"= '?'";
                return db.delete(TABLA,  whereClause, whereArgs);

            case CODE_NOTICIAS:
                return db.delete(TABLA, selection,selectionArgs);

            case CODE_AUTOR:
                throw  new UnsupportedOperationException("No se soporta el borrado de autor");
            case CODE_AUTORES:
                throw  new UnsupportedOperationException("No se soporta el borrado de autores");
            default:
                throw  new UnsupportedOperationException("No se soporta el borrado de autores");
        }

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch(matcher.match(uri)) {
            case CODE_NOTICIAS:
                db.insert(TABLA,CAMPO_TITULO, values);
                //tengo que devolver el uri correspondiente al registro que se acaba de insertar
                //Creo la uri a partir de la uri dereferencia añadiendole el codigo que esta en el values

                //1-extraemos el string de la uri

                return Uri.withAppendedPath(uri, values.getAsString(CAMPO_ID));

            case CODE_AUTOR:
                throw  new UnsupportedOperationException("No se soporta ");
            case CODE_AUTORES:
                throw  new UnsupportedOperationException("No se soporta ");
            default:
                throw  new UnsupportedOperationException("No se soporta ");
        }

    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        switch(matcher.match(uri)) {
            case CODE_NOTICIA:
                //para obtener el ultimo elemento del la uri que es el idid
                String[] whereArgs={uri.getLastPathSegment()};
                String whereClause=CAMPO_ID+"= '?'";
                return db.query(false, TABLA, projection, whereClause,  whereArgs, null, null, sortOrder, null);

            case CODE_NOTICIAS:
                return db.query(false, TABLA, projection, selection, selectionArgs, null, null, sortOrder, null);

            case CODE_AUTOR:
                throw  new UnsupportedOperationException("No se soporta ");
            case CODE_AUTORES:
                throw  new UnsupportedOperationException("No se soporta ");
            default:
                throw  new UnsupportedOperationException("No se soporta ");
        }

    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        switch(matcher.match(uri)) {
            case CODE_NOTICIA:
                //para obtener el ultimo elemento del la uri que es el idid
                String id = uri.getLastPathSegment();
                String[] whereArgs={id};
                String whereClause=CAMPO_ID+"= '?'";
                return db.update(TABLA, values,  whereClause, whereArgs);

            case CODE_NOTICIAS:
                return db.update(TABLA,values,  selection,selectionArgs);
            case CODE_AUTOR:
                throw  new UnsupportedOperationException("No se soporta ");
            case CODE_AUTORES:
                throw  new UnsupportedOperationException("No se soporta ");
            default:
                throw  new UnsupportedOperationException("No se soporta ");
        }

    }

    @Override
    public String getType(Uri uri) {

        switch(matcher.match(uri)) {
            case CODE_NOTICIA:
                return "vnd.android.cursor.item/vnd."+NOTICIAS_AUTHORITY+"."+NOTICIA_ENTIDAD;

            case CODE_NOTICIAS:
                return "vnd.android.cursor.dir/vnd."+NOTICIAS_AUTHORITY+"."+NOTICIA_ENTIDAD;

            case CODE_AUTOR:
                return "vnd.android.cursor.item/vnd."+NOTICIAS_AUTHORITY+"."+NOTICIA_ENTIDAD;


            case CODE_AUTORES:
                return "vnd.android.cursor.dir/vnd."+NOTICIAS_AUTHORITY+"."+NOTICIA_ENTIDAD;
            default:
                throw  new UnsupportedOperationException("No se soporta ");
        }

    }





}
