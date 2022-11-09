package com.example.tesicnor.Eventos;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tesicnor.DB.DeveloperuBD;
import com.example.tesicnor.Interpretadores.Interpretador_JSON;
import com.example.tesicnor.MainActivity;
import com.example.tesicnor.R;

import java.util.List;

public class Clickear_estrellas implements View.OnClickListener {


    private MainActivity entorno;
    private String idpelicula;
    private int position;
    private View convertView;
    int i;


    public Clickear_estrellas(int position, MainActivity entorno, String idpelicula, int i, View convertView) {
        this.position=position;
        this.entorno=entorno;
        this.idpelicula=idpelicula;
        this.i=i;
        this.convertView=convertView;

    }

    @SuppressLint("ResourceAsColor")
    @Override

    public void onClick(View view) {



        ImageButton unaestrella =  convertView.findViewById(R.id.estrella);
        ImageButton dosestrella =  convertView.findViewById(R.id.dosestrella);
        ImageButton tresestrella =  convertView.findViewById(R.id.tresestrella);
        ImageButton cuatroestrella =  convertView.findViewById(R.id.cuatroestrella);
        ImageButton cincoestrella =  convertView.findViewById(R.id.cincoestrella);


        final DeveloperuBD bd_consulta = new DeveloperuBD(entorno,"DEF",null,1);
        SQLiteDatabase db2= bd_consulta.getReadableDatabase();
        if (db2!=null){

            Cursor c2;



            switch(i) {
                case 1:
                   c2 = db2.rawQuery("update Personaas set Valoración='UNA' where ID='"+idpelicula+"'",null);//me actualiza
                    c2.moveToNext();
                    unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);

                    break;
                case 2:
                    c2 = db2.rawQuery("update Personaas set Valoración='DOS' where ID='"+idpelicula+"'",null);//me actualiza
                    c2.moveToNext();
                    unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);

                    break;
                case 3:
                    c2 = db2.rawQuery("update Personaas set Valoración='TRES' where ID='"+idpelicula+"'",null);//me actualiza
                    c2.moveToNext();
                    unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);
                    cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);

                    break;

                case 4:
                    c2 = db2.rawQuery("update Personaas set Valoración='CUATRO' where ID='"+idpelicula+"'",null);//me actualiza
                    c2.moveToNext();
                    unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.DARKEN);


                    break;

                case 5:
                    c2 = db2.rawQuery("update Personaas set Valoración='CINCO' where ID='"+idpelicula+"'",null);//me actualiza
                    c2.moveToNext();
                    unaestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    dosestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    tresestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    cuatroestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);
                    cincoestrella.getBackground().setColorFilter(Color.parseColor("#FFFF00"), PorterDuff.Mode.DARKEN);

                    break;
            }


    }
}

}