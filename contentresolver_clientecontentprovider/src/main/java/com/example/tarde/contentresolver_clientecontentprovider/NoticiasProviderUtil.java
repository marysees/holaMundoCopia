package com.example.tarde.contentresolver_clientecontentprovider;

import android.content.UriMatcher;
import android.net.Uri;

/**
 * Created by tarde on 10/02/2015.
 */
public interface NoticiasProviderUtil {

    public static final Uri NOTICIAS_URI=Uri.parse("content://com.curso.android.noticias/Noticia");
    public static final Uri AUTOR_URI=Uri.parse("content://com.curso.android.noticias/Autor");

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



}
