package com.example.prueba_de_sql.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DbCarros extends DbHelper{

    Context context;

    public DbCarros(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public long insertarCarro  (String placa, String color, String modelo) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("placa", placa);
            values.put("color", color);
            values.put("modelo", modelo);

            id = db.insert(TABLE_CARROS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

}
