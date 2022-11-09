package com.example.tesicnor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tesicnor.Adaptadores.Adaptador_Lista;
import com.example.tesicnor.RespuestasHthtp.Respuesta_Api;
import com.loopj.android.http.*;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consumir_api();

        TextView buscador =findViewById(R.id.buscador);
        ListView lista =findViewById(R.id.lista);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                lista.setAdapter(new Adaptador_Lista(MainActivity.this,charSequence));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }




    public void consumir_api() {

    String titulo = "Harry%20Potter";
    String tipo= "movie";


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(this, "http://www.omdbapi.com/?apikey=731e41f&s="+titulo+"&Type="+tipo,
               null,
                "application/json",  new Respuesta_Api(this,findViewById(R.id.lista)));


    }




    }






