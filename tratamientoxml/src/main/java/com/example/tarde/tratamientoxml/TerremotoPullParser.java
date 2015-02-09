package com.example.tarde.tratamientoxml;

///Mal incompleto ver el del Victor

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tarde on 06/02/2015.
 */
public class TerremotoPullParser {


    public TerremotoPullParser() {
        super();
    }

    public List<Terremoto> parse(InputStream is) throws IOException {
        LinkedList<Terremoto> terremotos = new LinkedList<>();
        Terremoto terremoto = null;

        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(is, "UTF-8");
            int event = xmlPullParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String tag = xmlPullParser.getName();

                if (tag.equals("entry")) {
                    terremoto = new Terremoto();
                } else if (tag.equals("id") && terremoto != null) {
                    String titulo = xmlPullParser.nextText();
                    terremoto.setId(titulo);
                    terremoto.setMagnitud(Float.valueOf(titulo.split(" ")[1]));
                } else if (tag.equals("title") && terremoto != null) {
                    terremoto.setTitulo(xmlPullParser.nextText());
                } else if (tag.equals("updated") && terremoto != null) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'E'HH:mm:ss.SSS'Z'");
                    Date date = dateFormat.parse(xmlPullParser.nextText());
                    terremoto.setFecha(date);

                } else if (tag.equals("link") && terremoto != null) {
                    terremoto.setLink(xmlPullParser.getAttributeValue(null, "href"));
                } else if (tag.equals("point") && terremoto != null) {
                    terremoto.setLink(xmlPullParser.getAttributeValue(null, "href"));
                    event = xmlPullParser.next();
                }

            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        return terremotos;
    }
}