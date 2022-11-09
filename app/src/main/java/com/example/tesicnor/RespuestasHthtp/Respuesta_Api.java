package com.example.tesicnor.RespuestasHthtp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tesicnor.Adaptadores.Adaptador_Lista;
import com.example.tesicnor.DB.DeveloperuBD;
import com.example.tesicnor.Interpretadores.Interpretador_JSON;
import com.example.tesicnor.MainActivity;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class Respuesta_Api  extends AsyncHttpResponseHandler {



    private MainActivity entorno;
    private Gson gson = new Gson();
    private List<Interpretador_JSON.Search> listapeliculas = new ArrayList<>();
    private ListView mListview;

    public Respuesta_Api(MainActivity entorno, ListView mListview) {
        this.entorno=entorno;
        this.mListview=mListview;

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

        String msg_json = new String(responseBody, StandardCharsets.UTF_8);
        Interpretador_JSON respuesta = gson.fromJson(msg_json, Interpretador_JSON.class);

        final DeveloperuBD bd_consulta = new DeveloperuBD(entorno,"DEF",null,1);
        SQLiteDatabase db = bd_consulta.getWritableDatabase();
        SQLiteDatabase db2= bd_consulta.getReadableDatabase();

        if (db!=null){
            ContentValues registronuevo = new ContentValues();//Añadire los datos del input

            for( int i=0; i<respuesta.Search.size();i++){//RECORRE EL TODOS LOS DATOS

                listapeliculas.add(i, respuesta.Search.get(i));
                String id = respuesta.Search.get(i).imdbID;
                String titulo2 = respuesta.Search.get(i).Title;
                String titulo= titulo2.replace("'","");
                String año = respuesta.Search.get(i).Year;

                Cursor c= db2.rawQuery("SELECT * from Personaas WHERE ID='"+id+"'",null);
                c.moveToNext();

                try {// ACTUALIZA DATOS si ya existe la ID

                    Cursor c2= db2.rawQuery("update Personaas set Año='"+año+"',TITULO='"+titulo+"'  where ID='"+c.getString(0)+"'",null);//me actualiza
                    c2.moveToNext();

                } catch(Exception e) { //Inserta datos si no existe la ID


                    registronuevo.put("ID",id);
                    registronuevo.put("Titulo",titulo);
                    registronuevo.put("Año",año);
                    registronuevo.put("Valoración","CERO");
                    db.insert("Personaas",null,registronuevo);


                }

            }


        }

        mListview.setAdapter(new Adaptador_Lista(entorno,""));




    }



    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

        Toast.makeText(entorno, "Sin conexion a Internet", Toast.LENGTH_SHORT).show();

        //necesitamos saber cuantos datos meteremos

        final DeveloperuBD bd_consulta = new DeveloperuBD(entorno,"DEF",null,1);
        SQLiteDatabase db2= bd_consulta.getReadableDatabase();
        Cursor c= db2.rawQuery("SELECT * from Personaas",null);
        c.moveToNext();
        mListview.setAdapter(new Adaptador_Lista(entorno, ""));



    }
}
