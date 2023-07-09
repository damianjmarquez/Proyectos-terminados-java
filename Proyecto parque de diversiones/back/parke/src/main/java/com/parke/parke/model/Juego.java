package com.parke.parke.model;


import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Juego {
	
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private int cantidadDePersonas;
	private int precio;
	private String empleado;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime horaInicio;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime horaFin;
	
	
	public Juego() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidadDePersonas() {
		return cantidadDePersonas;
	}


	public void setCantidadDePersonas(int cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getEmpleado() {
		return empleado;
	}


	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
	
	
}
