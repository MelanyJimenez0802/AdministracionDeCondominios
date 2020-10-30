package com.example.administracindecondominios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.parseColor;

public class MainActivity_Estadodecuenta extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_FI, txt_FF;
    private TableLayout tableLayout;
    private Button btn1;
    private int ntabla = 0;
    private String [] fechas= {"3/10/2020", "11/10/2020", "25/10/2020"};
    private String [] descripcion = {"Cuota condominal Octubre", "Alquiler Salon Miraflores", "Transferenciabancaria #1254789"};
    private String [] monto = {"₡15 000", "₡21 000", "₡80 000"};

    private String[][] matriz1 = new String[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__estadodecuenta);

        txt_FI =(EditText)findViewById(R.id.txt_fechaInicial);
        txt_FF = (EditText)findViewById(R.id.txt_fechaFinal);
        btn1 = (Button)findViewById(R.id.btn_consultar);
        btn1.setOnClickListener((View.OnClickListener) this);
        tableLayout = (TableLayout)findViewById(R.id.tabla_layout);

        tableLayout.setVisibility(tableLayout.INVISIBLE);

        matriz1 [0] = fechas;
        matriz1 [1] = descripcion;
        matriz1 [2] = monto;
    }

    public void llenarTabla(){
        if(tableLayout.getChildCount()>1){
            Log.i("fslog","nrows=" + tableLayout.getChildCount());

            //Una bandera para identificar si ya hay una tabla y si hay borrarla primero antes de llenar los datos
            int filas = tableLayout.getChildCount();

            tableLayout.removeViews(1, filas -1);
            for (int i=0; i<matriz1[i].length; i++) {
                Log.i("fslog", "matriz1[i].length = " + matriz1[i].length);
                TableRow fila = new TableRow(this);
                /*fila.setBackground(parseColor("#FDFFA5"));*/
                Log.i("fslog", "matriz1.length=" + matriz1.length);
                TextView tv1 = new TextView(this);
                TextView tv2 = new TextView(this);
                TextView tv3 = new TextView(this);
                Log.i("fslog", "text=" + matriz1[i][0]);
                tv1.setText(matriz1[0][i]);
                tv2.setText(matriz1[1][i]);
                tv3.setText(matriz1[2][i]);

                fila.addView(tv1);
                fila.addView(tv2);
                fila.addView(tv3);
                tableLayout.addView(fila);
                Log.i("fslog", "fila added=");
            }
        }else{
                for (int i=0; i<matriz1[i].length; i++) {
                    Log.i("fslog", "matriz1[i].length = " + matriz1[i].length);
                    TableRow fila = new TableRow(this);
                    /*fila.setBackground(parseColor("#FDFFA5"));*/
                    Log.i("fslog", "matriz1.length=" + matriz1.length);
                    TextView tv1 = new TextView(this);
                    TextView tv2 = new TextView(this);
                    TextView tv3 = new TextView(this);
                    Log.i("fslog", "text=" + matriz1[i][0]);
                    tv1.setText(matriz1[0][i]);
                    tv2.setText(matriz1[1][i]);
                    tv3.setText(matriz1[2][i]);

                    fila.addView(tv1);
                    fila.addView(tv2);
                    fila.addView(tv3);
                    tableLayout.addView(fila);
                    Log.i("fslog", "fila added=");
                }
        }
    }



    @Override
    public void onClick(View view) {
        tableLayout.setVisibility(tableLayout.VISIBLE);

        switch (view.getId()){
            case R.id.btn_consultar:
                llenarTabla();
                ntabla=1;
                break;
        }
    }
}