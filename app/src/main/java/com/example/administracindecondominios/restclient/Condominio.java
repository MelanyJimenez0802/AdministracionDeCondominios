package com.example.administracindecondominios.restclient;

import com.google.gson.annotations.SerializedName;

public class Condominio {
	@SerializedName("id")
	private String id;
	@SerializedName("nombre")
	private String nombre;
	@SerializedName("direccion")
	private String direccion;
	
	
	
	
	public Condominio(String id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
