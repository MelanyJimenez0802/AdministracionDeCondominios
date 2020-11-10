package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administracindecondominios.database.DBHelper;
import com.example.administracindecondominios.database.dao.Reservacion;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity_CalendarioReserva extends AppCompatActivity implements View.OnClickListener {

    Button btn_fecha, btn_hora, btn_reserva;
    EditText et_fecha;
    EditText et_hora;
    private int dia,mes,ano,hora,minutos;
    private TableLayout tableLayout;

    JSONObject reserva = new JSONObject();
    SharedPreferences preferencias;
    SharedPreferences.Editor editor;

    private List<String> lista1 = new ArrayList<>();
    private ArrayAdapter<String> adapter1;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__calendario_reserva);


        btn_fecha = (Button)findViewById(R.id.button_fecha);
        btn_hora = (Button)findViewById(R.id.button_hora);
        btn_reserva = (Button)findViewById(R.id.button_reserva);
        et_fecha = (EditText)findViewById(R.id.editTextDate);
        et_hora = (EditText)findViewById(R.id.editTextTime);
        tableLayout = (TableLayout)findViewById(R.id.tabla_layout);

        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);


        tableLayout.setVisibility(tableLayout.INVISIBLE);


        
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
        dbHelper = new DBHelper(this);

    }

    private void init() {
        preferencias = getSharedPreferences("text", Context.MODE_PRIVATE);
        editor = preferencias.edit();
        btn_reserva = (Button)findViewById(R.id.button_reserva);
        et_fecha = (EditText)findViewById(R.id.editTextDate);
        et_hora = (EditText)findViewById(R.id.editTextTime);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }*/


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

    //Probar para guardar en Base de Datos
    public void Reservar(View view){
        String s3 = et_fecha.getText().toString();
        String s4 = et_hora.getText().toString();


        if(!s3.isEmpty() | !s4.isEmpty()){

            Reservacion reservacion = new Reservacion();
            reservacion.setUserId("user@domain.com");
            reservacion.setFechaHora(s3+" "+s4);

            try {
                //dbHelper.createOrUpdate(student);
                dbHelper.createOrUpdate(reservacion);
                et_fecha.setText("");
                et_hora.setText("");
                List<Reservacion> list =dbHelper.getAll(Reservacion.class);
                for(Reservacion r:list){
                    TableRow fila = new TableRow(this);
                    fila.setPadding(0, 0, 0, 10);
                    TextView tv1 = new TextView(this);
                    TextView tv2 = new TextView(this);
                    tv1.setText(r.getUserId());
                    tv2.setText(r.getFechaHora());

                    fila.addView(tv1);
                    fila.addView(tv2);
                    tableLayout.addView(fila);
                    Log.i("fslog", "fila added=");
                    Toast.makeText(this, r.getUserId()+" "+r.getFechaHora(), Toast.LENGTH_SHORT).show();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            tableLayout.setVisibility(tableLayout.VISIBLE);


        }else {
            Toast.makeText(this, "Primero debes llenar los campos", Toast.LENGTH_SHORT).show();

        }
    }
}