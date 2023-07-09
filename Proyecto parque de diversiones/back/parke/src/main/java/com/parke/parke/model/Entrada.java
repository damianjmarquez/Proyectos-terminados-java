package com.parke.parke.model;


import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entrada {
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String dni;
	private String juego;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha;
	private Long precio;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime hora;
	
	public Entrada() {
		super();
	}

	public Entrada(int id, String dni, String juego, Date fecha,  Long precio) {
		super();
		this.id = id;
		this.dni = dni;
		this.juego = juego;
		this.fecha = fecha;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}
	
	

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
	
	
	
	
}
