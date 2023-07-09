package com.tpFinal.Deportivo;

import java.util.ArrayList;

public class Equipos {
	ArrayList<String> listaEquipo;
	ArrayList<Integer> listaRonda = new ArrayList<Integer>();
	String descripcion;
	String[] separado;
	String lineacsv;
	int ronda;
	
	
	//CREANDO CONSTRUCTOR CON LOS PARAMETROS RESIBIDOS
	public Equipos(ArrayList<Integer> listaRonda, ArrayList<String> listaEquipo ,String descripcion) {
		this.descripcion = descripcion;
		this.listaEquipo = listaEquipo;
		this.listaRonda = listaRonda;
	}
	 
	//CREANDO METODO QUE LLAMA A LOS EQUIPOS Y MUESTRA EN PANTALLA LA LISTA DE ELLOS POR RONDA 
	public void llamarEquipo() {
		System.out.println("-----------PARTICIPARON 4 EQUIPOS POR RONDA EN UN TOTAL DE   " + listaRonda.size() + " RONDAS----------");
		
		
		//RECORRIENDO LA LISTA DE RONDAS 
		for (int x =0; x<listaRonda.size(); x++) {
			System.out.println("\n" + "\n");
			System.out.println("................RONDA NUMERO " + (x+1) + "................");
			System.out.println();
			
			//DENTRO DE LA LISTA DE RONDAS SE RECORRE LA LISTA DE EQUIPOS 
			for(int i=0; i<listaEquipo.size(); i++) {
				lineacsv = listaEquipo.get(i);
				separado = lineacsv.split(";");
				ronda = Integer.parseInt(separado[0]);
				if (ronda== (x+1) ) {
					System.out.println("----------> " + (i+1) +  " " + separado[1] + " " +  " Seleccion Nacional " + "----------------" + "\n");
				}
			
			} // FIN DENTRO DE LA LISTA DE RONDAS SE RECORRE LA LISTA DE EQUIPOS
			
		}// FIN DE RECORRIENDO LA LISTA DE RONDAS 
	
	}
		
}
