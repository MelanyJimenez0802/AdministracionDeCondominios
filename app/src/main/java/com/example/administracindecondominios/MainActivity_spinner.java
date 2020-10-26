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

import com.example.administracindecondominios.restclient.APIClient;
import com.example.administracindecondominios.restclient.APIInterface;
import com.example.administracindecondominios.restclient.Condominio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_spinner extends AppCompatActivity {


    private Spinner spinner1;
    private APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        ArrayList<String> opciones = new ArrayList<String>();

        getCondominios(opciones, "Cesar");

        spinner1 = (Spinner) findViewById(R.id.spinner);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_melany, opciones);
        spinner1.setAdapter(adapter);

    }

    private void getCondominios(final ArrayList<String> opciones, String userId) {
        Call<List<Condominio>> call = apiInterface.doGetCondominios(userId);
        call.enqueue(new Callback<List<Condominio>>() {
            @Override
            public void onResponse(Call<List<Condominio>> call, Response<List<Condominio>> response) {

                List<Condominio> condominios = response.body();

                for (Condominio condominio : condominios) {
                    opciones.add(condominio.getNombre());
                    Toast.makeText(getApplicationContext(), "id : " + condominio.getId() + " nombre: " + condominio.getNombre(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<List<Condominio>> call, Throwable t) {
                call.cancel();
            }
        });
    }


    //Pasar del botón aceptar a la siguiente pantalla
    public void Aceptar(View view){
        Intent aceptar = new Intent(this, MainActivity2_Menu.class);
        startActivity(aceptar);
    }


}