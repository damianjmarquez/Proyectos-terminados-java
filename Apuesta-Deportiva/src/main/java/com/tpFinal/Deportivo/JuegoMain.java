package com.tpFinal.Deportivo;


import java.sql.SQLException;
import java.util.ArrayList;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;




public class JuegoMain {

	public static void main(String[] args) throws SQLException {
	
		//ATRIBUTOS PARA LLAMAR A LA BASE DE DATOS
		baseDeDatos bdpa = new baseDeDatos();
		ArrayList<String> listacsv = new ArrayList<String>();
		ArrayList<String> listacsv2 = new ArrayList();
		
		//GUARDANDO LAS BASES DE DATOS EN UN ARRAYLIST
		listacsv = bdpa.bdPartidos();
		listacsv2 = bdpa.bdPronostico();
		
		// IMPRESION DEL PROGRAMA
		
		System.out.println("-----------------------BIENVENIDOS AL PRONOSTICO DEPORTIVO------------------------");
		System.out.println("\n");
		
		System.out.println("-----------------------FELICITACIONES AL GANADOR DE ESTE ENCUENTRO------------------------" + "\n");
		
		//CREANDO OBJETOS CON LOS EQUIPOS
		Resultados equipo = new Resultados(listacsv,listacsv2);
		Equipos nuev = new Equipos(equipo.rondas, listacsv, "descripcion");
		equipo.leerLinea();
		System.out.println("\n");
		
		nuev.llamarEquipo();
		
	}
}
