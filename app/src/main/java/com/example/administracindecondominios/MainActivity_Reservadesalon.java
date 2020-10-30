package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity_Reservadesalon extends AppCompatActivity {
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__reservadesalon);

        spinner1 = (Spinner) findViewById(R.id.spinner2);

        String[] opciones = {"Salón BBQ", "Salón de Fiesta", "Cancha Multiuso"};



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_melany, opciones);
        spinner1.setAdapter(adapter);
    }

    //Pasar del botón aceptar a la siguiente pantalla
    public void Aceptar(View view){
        Intent aceptar = new Intent(this, MainActivity_CalendarioReserva.class);
        startActivity(aceptar);

    }
}
