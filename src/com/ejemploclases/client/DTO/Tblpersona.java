package com.ejemploclases.client.DTO;

import java.io.Serializable;

public class Tblpersona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String nombre;
	public String apellido;
	public String direccion;
	private Integer edad;
	
	public Tblpersona(){
		
	}
	
	public Tblpersona(String id, String nombre, String apellido, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private void setEdad(Integer edad) {
		this.edad = edad;
	}

	private Integer getEdad() {
		return edad;
	}
	
}
