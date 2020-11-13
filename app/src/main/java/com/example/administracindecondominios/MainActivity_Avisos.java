package com.example.administracindecondominios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity_Avisos extends AppCompatActivity {

    String[] avisos = {"30/10/2020 Corte de Agua","31/10/2020 Fiesta Infantil", "5/11/2020 Convocatoria a Asamblea"};
    String[] mensaje = {"Se estará suspendiendo el servicio de agua de 5 a.m a 10 a.m por limpieza de tanques.", "Se realizará una fiesta infaltil a las 6 p.m, para celebrar Halloween. Favor venir disfrazado.", "Se convoca asamblea de rutina 3 p.m a 5 p.m"};
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__avisos);
        setTitle("Avisos");

        lv1 = (ListView)findViewById(R.id.lv);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, avisos);
        lv1.setAdapter(arrayAdapter);

        //Agregar la acción del listener
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Llamamos al dialogó para mostrar detalles
                //Creamos el dialogo del activity
                Intent intent = new Intent(getApplicationContext(), MainActivity_DialogoDetalles.class);
                intent.putExtra("mensaje", mensaje[i]);
                startActivity(intent);


            }
        });
    }


}