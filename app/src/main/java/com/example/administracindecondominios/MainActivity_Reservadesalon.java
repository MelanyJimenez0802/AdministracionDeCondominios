package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        setTitle("Reservar Salón");

        spinner1 = (Spinner) findViewById(R.id.spinner2);

        String[] opciones = {"Salón BBQ", "Salón de Fiesta", "Cancha Multiuso"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_melany, opciones);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Salón BBQ")) {
                    int check =0;
                    if(++check > 1) {
                        TextView textView = (TextView) findViewById(R.id.txt_seleccion);
                        String str = (String) parent.getItemAtPosition(position);
                        textView.setText(str);
                    }
                    Intent aceptar = new Intent(MainActivity_Reservadesalon.this, MainActivity_CalendarioReserva.class);
                    startActivity(aceptar);

                }
                if(parent.getItemAtPosition(position).equals("Salón de Fiesta")){
                    Intent aceptar = new Intent(MainActivity_Reservadesalon.this, MainActivity_CalendarioReserva.class);
                    startActivity(aceptar);


                }
                if(parent.getItemAtPosition(position).equals("Cancha Multiuso")){
                    Intent aceptar = new Intent(MainActivity_Reservadesalon.this, MainActivity_CalendarioReserva.class);
                    startActivity(aceptar);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
