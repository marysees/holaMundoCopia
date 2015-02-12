package com.example.tarde.gestos;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements GestureOverlayView.OnGesturePerformedListener{
    GestureLibrary gestureLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureLib =
                GestureLibraries.fromRawResource(this, R.raw.gestures);

        GestureOverlayView gestureOverlay= (GestureOverlayView) findViewById(R.id.gesture);
        gestureOverlay.addOnGesturePerformedListener(this);

    }


    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {


        ArrayList<Prediction> recognize= gestureLib.recognize(gesture);

        for(Prediction prediccion:recognize){
            Toast.makeText(this, "Gesto: "+ prediccion.name+" Score: "+ prediccion.score, Toast.LENGTH_SHORT).show();
        }

    }
}
