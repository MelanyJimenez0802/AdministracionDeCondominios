package com.example.administracindecondominios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity_DialogoDetalles extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__dialogo_detalles);

        Intent intent = getIntent();
        String val = intent.getStringExtra("mensaje");

        textView = (TextView)findViewById(R.id.tv_detalle);
        textView.setText(val);

    }

    private void Personalizado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_main__dialogo_detalles, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}