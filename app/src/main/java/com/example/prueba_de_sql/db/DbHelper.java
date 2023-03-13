package com.example.prueba_de_sql.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int  DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static final String TABLE_CARROS = "t_carros";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CARROS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "placa TEXT NOT NULL," +
                "color TEXT NOT NULL," +
                "modelo TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CARROS);
        onCreate(sqLiteDatabase);
    }
}
