package com.example.cyndi.proyecto;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by cyndi on 01/06/2017.
 */

public class Reproduccion extends Activity {

    MediaPlayer mp;
    boolean Bandera;

    int posi;
    int cont;
    public int [] listCanciones = {R.raw.feelinggood, R.raw.eres, R.raw.bangin, R.raw.candles, R.raw.clementine};
    public Button play = (Button) findViewById(R.id.Play);

    MainActivity ma = new MainActivity ();


    protected void onCreate (Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
        setContentView(R.layout.reproduccion);
        Bundle datos = this.getIntent().getExtras();
        posi = datos.getInt("seleccion");
        cont = posi;
        Repro();
    }

    protected void onPause(){
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        mp.pause();
        Bandera = false;
        super.onPause();
    }

    public void Repro(){

        mp = MediaPlayer.create(this,listCanciones[posi] );
        mp.start();
        Bandera = true;
    }

    public  void buttonPlay(View view){
        if(Bandera){
            mp.pause();
            play.setText(" ▌▌");
            Bandera = false;
        }
        else{
            mp.start();
            play.setText("▶");
            Bandera = true;
        }

    }

    public void buttonPre(View view){

    }

    public void buttonNext(View view){
        mp.pause();
        cont++;
       mp = MediaPlayer.create(this, listCanciones[cont]);
        mp.start();
        Bandera = true;

    }
}
