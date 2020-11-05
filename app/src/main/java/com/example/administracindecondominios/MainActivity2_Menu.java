package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2__menu);
    }

    //Pasar a la siguiente pantalla, Estado de cuenta
    public void Estado(View view){
        Intent estado = new Intent(this, MainActivity_EstadoDeCuenta.class);
        startActivity(estado);
    }

    //Pasar a la siguiente pantalla, Reserva del salón
    public void Reserva(View view){
        Intent reserva = new Intent(this, MainActivity_Reservadesalon.class);
        startActivity(reserva);
    }

    //Pasar a la siguiente pantalla, Avisos
    public void Avisos(View view){
        Intent avisos = new Intent(this, MainActivity_Avisos.class);
        startActivity(avisos);
    }

    //Pasar a la siguiente pantalla, Configuración
    public void Configuración(View view){
        Intent configuracion = new Intent(this, MainActivity_Configuracion.class);
        startActivity(configuracion);
    }
}