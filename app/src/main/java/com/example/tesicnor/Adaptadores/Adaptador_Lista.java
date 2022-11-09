package com.example.tesicnor.Adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tesicnor.DB.DeveloperuBD;
import com.example.tesicnor.Eventos.Clickear_estrellas;
import com.example.tesicnor.MainActivity;
import com.example.tesicnor.R;

public class Adaptador_Lista extends BaseAdapter {

    private Context entorno;
    private CharSequence charSequence;


    public Adaptador_Lista(MainActivity entorno, CharSequence charSequence) {
        this.entorno=entorno;
        this.charSequence=charSequence;

    }


    @Override
    public int getCount() {// mostrara como tantos responda la DB, debemos saber la longitud


            final DeveloperuBD bd_consulta = new DeveloperuBD(entorno,"DEF",null,1);
            SQLiteDatabase db2= bd_consulta.getReadableDatabase();
            Cursor c = null;

            if (db2!=null){
                    if(charSequence.toString().length()<4){
                        c= db2.rawQuery("select * from Personaas ",null);
                    }else{
                        c= db2.rawQuery("select * from Personaas where Año='"+charSequence+"'",null);
                    }

                c.moveToNext();
            }

            return c.getCount();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) entorno.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_peliculas, null);

        }


        TextView id = convertView.findViewById(R.id.id);
        TextView titulo = convertView.findViewById(R.id.titulo);
        TextView año = convertView.findViewById(R.id.año);
        TextView valoracion = convertView.findViewById(R.id.valora2);
        TextView buscador =convertView.findViewById(R.id.buscador);



        final DeveloperuBD bd_consulta = new DeveloperuBD(entorno,"DEF",null,1);
        SQLiteDatabase db2= bd_consulta.getReadableDatabase();
        if (db2!=null){// AÑADE DATOS A LA LISTVIEW
            Cursor c= db2.rawQuery("select * from Personaas where Año='"+charSequence+"'",null);
          if(charSequence.toString().length()<4){
              c= db2.rawQuery("select * from Personaas ",null);
          }else{
              c= db2.rawQuery("select * from Personaas where Año='"+charSequence+"'",null);
          }



                try{
                    c.moveToPosition(position);

                    String linea =c.getString(0) ;
                    String linea1 =c.getString(1) ;
                    String linea2 =c.getString(2) ;
                    String linea3 =c.getString(3) ;


                    id.setText(linea);
                    titulo.setText(linea1);
                    año.setText(linea2);
                    //valoracion.setText(linea3);

                    ImageButton unaestrella =  convertView.findViewById(R.id.estrella);
                    ImageButton dosestrella =  convertView.findViewById(R.id.dosestrella);
                    ImageButton tresestrella =  convertView.findViewById(R.id.tresestrella);
                    ImageButton cuatroestrella =  convertView.findViewById(R.id.cuatroestrella);
                    ImageButton cincoestrella =  convertView.findViewById(R.id.cincoestrella);



                    switch(linea3) {

                        default:

                            unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);

                            break;
                        case "DOS":

                            unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);

                            break;
                        case "TRES":

                            unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            break;

                        case "CUATRO":

                            unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                            break;

                        case "CINCO":

                            unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                            cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);

                            break;

                    }
                    unaestrella.setOnClickListener( new Clickear_estrellas(position, (MainActivity) entorno,linea,1,convertView));
                    dosestrella.setOnClickListener( new Clickear_estrellas(position, (MainActivity) entorno,linea,2,convertView));
                    tresestrella.setOnClickListener( new Clickear_estrellas(position, (MainActivity) entorno,linea,3,convertView));
                    cuatroestrella.setOnClickListener( new Clickear_estrellas(position, (MainActivity) entorno,linea,4,convertView));
                    cincoestrella.setOnClickListener( new Clickear_estrellas(position, (MainActivity) entorno,linea,5,convertView));
                }catch (Exception e){

                }


                        }









        return convertView;


    }
}
