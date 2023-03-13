package com.example.prueba_de_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prueba_de_sql.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    public Button btnCrear , siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null )
                {
                    Toast.makeText(MainActivity.this, "Dase de datos creada", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error en la creacion", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void NuevoActivity(View view)
    {
        siguiente = findViewById(R.id.siguiente);
        Intent Enviar = new Intent(this,NuevoActivity2.class);
        startActivity(Enviar);
    }
}