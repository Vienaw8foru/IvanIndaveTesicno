package com.example.tesicnor.DB;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import androidx.annotation.Nullable;


public class DeveloperuBD extends SQLiteOpenHelper{

    String tabla= "CREATE TABLE Personaas(ID TEXT PRIMARY KEY, Titulo TEXT, Año TEXT, Valoración TEXT)";

    public DeveloperuBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
