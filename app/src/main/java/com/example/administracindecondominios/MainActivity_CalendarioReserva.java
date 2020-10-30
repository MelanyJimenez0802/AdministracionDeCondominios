package com.example.administracindecondominios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class MainActivity_CalendarioReserva extends AppCompatActivity implements View.OnClickListener {

    Button btn_fecha, btn_hora, btn_reserva;
    EditText et_fecha, et_hora;
    private int dia,mes,ano,hora,minutos;

    JSONObject reserva = new JSONObject();
    SharedPreferences preferencias;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__calendario_reserva);


        btn_fecha = (Button)findViewById(R.id.button_fecha);
        btn_hora = (Button)findViewById(R.id.button_hora);
        btn_reserva = (Button)findViewById(R.id.button_reserva);
        et_fecha = (EditText)findViewById(R.id.editTextDate);
        et_hora = (EditText)findViewById(R.id.editTextTime);

        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);
        
        init();
        Intent intent =getIntent();
        if(intent.getIntExtra("position", -1)!= -1){
            try {
                String s1 = et_fecha.getText().toString();
                String s2 = et_hora.getText().toString();

                if(!preferencias.getString("reserva", "").equals(""))
                    reserva = new JSONObject(preferencias.getString("reserva", ""));
                et_fecha.setText(reserva.getString("reserva"+intent.getIntExtra("posicion", 0)));

                s1 = reserva.getString("reserva"+intent.getIntExtra("posicion", 0));
                s2 = reserva.getString("reserva"+intent.getIntExtra("posicion", 0));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }

    private void init() {
        preferencias = getSharedPreferences("text", Context.MODE_PRIVATE);
        editor = preferencias.edit();
        btn_reserva = (Button)findViewById(R.id.button_reserva);
        et_fecha = (EditText)findViewById(R.id.editTextDate);
        et_hora = (EditText)findViewById(R.id.editTextTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.reserva){
            if(preferencias.getString("reserva", "").equals("")){
                Toast.makeText(getApplicationContext(), "No hay nada guardado", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(MainActivity_CalendarioReserva.this, MainActivity_ReservasGuardadas.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view==btn_fecha){
            final Calendar calendario = Calendar.getInstance();
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            mes = calendario.get(Calendar.MONTH);
            ano = calendario.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    et_fecha.setText(dayOfMonth + " / " + (monthOfYear+1) + " / " + year);

                }
            }

            ,ano,mes,dia);


            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

            datePickerDialog.show();

        }

        if(view==btn_hora){
            final Calendar calendario = Calendar.getInstance();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                    et_hora.setText(hourOfDay + ":" + minute);

                }
            }
            ,hora,minutos,false);
            timePickerDialog.show();

        }
    }



    public void Reservar(View view){

        String s3 = et_fecha.getText().toString();
        String s4 = et_hora.getText().toString();

        if(!s3.equals("") | !s4.equals("")){
            try {
                if(!preferencias.getString("reservar", "").equals(""))
                    reserva = new JSONObject(preferencias.getString("reserva", ""));
                reserva.put("reservar"+reserva.length(),s3);
                reserva.put("reservar"+reserva.length(),s4);
            }catch (JSONException e){
                e.printStackTrace();
            }

            Log.d("testing", reserva+"");
            editor.putString("reserva",reserva.toString());
            editor.apply();
            et_fecha.setText("");
            et_hora.setText("");

            Toast.makeText(this, "La reservación ha sido exitosa", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity_CalendarioReserva.this, MainActivity_ReservasGuardadas.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Primero debes llenar los campos", Toast.LENGTH_SHORT).show();

            et_fecha.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_fecha, InputMethodManager.SHOW_IMPLICIT);

        }
    }
}