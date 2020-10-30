package com.example.administracindecondominios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity_ReservasGuardadas extends AppCompatActivity {

    RecyclerView recyclerView;
    SharedPreferences preferences;
    JSONObject reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__reservas_guardadas);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        preferences = getSharedPreferences("text", Context.MODE_PRIVATE);
        Log.d("Testing", preferences.getString("reserva", ""));
        try {
            reserva = new JSONObject(preferences.getString("reserva", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity_ReservasGuardadas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter());
    }

    public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
        @NonNull
        @Override
        public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(MainActivity_ReservasGuardadas.this).inflate(R.layout.row_item, viewGroup, false);
            Holder holder = new Holder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = recyclerView.getChildPosition(view);
                    Intent intent = new Intent(MainActivity_ReservasGuardadas.this, MainActivity_CalendarioReserva.class);

                    intent.putExtra("position", posicion);
                    startActivity(intent);
                }


            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.Holder holder, int position) {
            try {
                holder.txtView.setText(reserva.getString("reservar"+position));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public int getItemCount() {
            return reserva.length();
        }

        public class Holder extends RecyclerView.ViewHolder {
            TextView txtView;

            public Holder(@NonNull View itemView) {
                super(itemView);
                txtView = itemView.findViewById(R.id.text_view);
            }
        }
    }


        public enum Holder {}
    }