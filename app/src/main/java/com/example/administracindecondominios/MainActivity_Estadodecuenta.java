package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_Estadodecuenta extends AppCompatActivity {

    private EditText txt_FI, txt_FF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__estadodecuenta);

        txt_FI =(EditText)findViewById(R.id.txt_fechaInicial);
        txt_FF = (EditText)findViewById(R.id.txt_fechaFinal);
    }

    public void Consultar(View view){
        if(!txt_FI.equals("") | !txt_FF.equals("")){
            Intent consultar = new Intent(this, MainActivity_MovimientosCuenta.class);
            startActivity(consultar);
        }else{
            Toast.makeText(this, "Primero debes llenar los campos", Toast.LENGTH_SHORT).show();

            txt_FI.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(txt_FI, InputMethodManager.SHOW_IMPLICIT);

        }
    }


}