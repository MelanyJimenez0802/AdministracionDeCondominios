package com.example.administracindecondominios.database.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "reservacion")
public class Reservacion {


    @DatabaseField(columnName = "id",generatedId = true)
    private int id;

    @DatabaseField(columnName = "user_id")
    private String userId;

    @DatabaseField(columnName = "fecha_hora")
    private String fechaHora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}
