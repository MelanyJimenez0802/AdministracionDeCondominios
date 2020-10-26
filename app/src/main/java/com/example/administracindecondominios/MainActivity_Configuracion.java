package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Configuracion extends AppCompatActivity implements View.OnClickListener{

    private Button btn_insertar1;
    private EditText et_identificacion1, et_nombre1, et_telefono1;
    private ListView lv;
    private List<String> lista1 = new ArrayList<>();
    private ArrayAdapter<String> adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__configuracion);

        btn_insertar1 = (Button)findViewById(R.id.btn_insertar);
        et_identificacion1 = (EditText)findViewById(R.id.et_Identificacion);
        et_nombre1 = (EditText)findViewById(R.id.et_nombre);
        et_telefono1 = (EditText)findViewById(R.id.et_telefono);
        lv = (ListView)findViewById(R.id.lv1);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //Obtener los campos de texto
            case R.id.btn_insertar: String texto = et_identificacion1.getText().toString().trim() + et_nombre1.getText().toString().trim() + et_telefono1.getText().toString().trim();
            et_identificacion1.setText("  ");
            lista1.add(texto);

            //Para que se borren los datos
            et_identificacion1.getText().clear();
            et_nombre1.getText().clear();
            et_telefono1.getText().clear();

            //Agregar a la lista
            adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista1); //Agregar a la lista
            lv.setAdapter(adapter1);
            lv.onSaveInstanceState();



        }
    }
}