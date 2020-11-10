package com.example.administracindecondominios.database.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "usuario")

public class Usuario {

    @DatabaseField(columnName = "id",generatedId = true)
    private int id;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "nombre")
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String email) {
        this.nombre = nombre;
    }
}
