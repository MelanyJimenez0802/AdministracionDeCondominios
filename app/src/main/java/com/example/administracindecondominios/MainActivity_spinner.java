package com.example.administracindecondominios;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_spinner extends AppCompatActivity {


    private Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);


        spinner1 = (Spinner) findViewById(R.id.spinner);


        String[] opciones = {"3564", "7894", "7458"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_melany, opciones);
        spinner1.setAdapter(adapter);

    }



    //Pasar del botón aceptar a la siguiente pantalla
    public void Aceptar(View view){
        Intent aceptar = new Intent(this, MainActivity2_Menu.class);
        startActivity(aceptar);
    }


}