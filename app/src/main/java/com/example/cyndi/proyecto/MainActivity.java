package com.example.cyndi.proyecto;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private ListView Lista;
    //private MediaPlayer mp = new MediaPlayer();


//    Reproduccion rp = new Reproduccion();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista = (ListView)findViewById(R.id.listView);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Feeling Good");
        strings.add("Eres");
        strings.add("Bangin");
        strings.add("Candles");
        strings.add("Clementine");
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
        Lista.setAdapter(adaptador);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getApplicationContext(), Reproduccion.class);
                    i.putExtra("seleccion", id);
                    startActivity(i);
            }
        });


    }

}
