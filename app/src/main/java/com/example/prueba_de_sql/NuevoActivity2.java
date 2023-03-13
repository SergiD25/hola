package com.example.prueba_de_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba_de_sql.db.DbCarros;

public class NuevoActivity2 extends AppCompatActivity {

    EditText placa , color , modelo;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo2);

        placa = findViewById(R.id.placa);
        color = findViewById(R.id.color);
        modelo = findViewById(R.id.modelo);
        guardar = findViewById(R.id.guardar);



        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbCarros dbCarros = new DbCarros(NuevoActivity2.this);
                long id = dbCarros.insertarCarro(placa.getText().toString(),color.getText().toString(),modelo.getText().toString());

                if (id >  0){
                    Toast.makeText(NuevoActivity2.this, "Registro guardado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NuevoActivity2.this, "No se guardo el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar() {
        placa.setText("");
        color.setText("");
        modelo.setText("");
    }
}