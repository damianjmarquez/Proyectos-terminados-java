package com.tpFinal.Deportivo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.logging.log4j.util.PropertySource.Comparator;



public class Resultados {
	
	//NOMBRE DE ATRIBUTOS UTILIZADOS EN LA CLASE
	
	Map<String,Integer> puntosGuardados = new HashMap<String,Integer>();
	ArrayList<String> idPartidos  = new ArrayList<String>();
	ArrayList<String> listacsv  = new ArrayList<String>();
	ArrayList<String> idJugadores = new ArrayList<String>();
	ArrayList<String> jugadores = new ArrayList<String>();
	ArrayList<String> EquiposJuego = new ArrayList<String>();
	ArrayList<Integer> rondas = new ArrayList<Integer>();
	ArrayList<String> rondasPronostico = new ArrayList<String>();
	ArrayList<String> listacsv2  = new ArrayList<String>();
	ArrayList<String> localPartido  = new ArrayList<String>();
	ArrayList<String> visitantePartido  = new ArrayList<String>();
	ArrayList<String> localPronostico  = new ArrayList<String>();
	ArrayList<String> visitantePronostico  = new ArrayList<String>();
	ArrayList<String> ganador  = new ArrayList<String>();
	ArrayList<String> empate  = new ArrayList<String>();
	ArrayList<String> perdedor  = new ArrayList<String>();
	String lineaPartido;
	String jugador;
	String lineas;
	String ganoequipo1;
	String lineacsv;
	String[] separado1;
	String[] lineaIdJugadores;
	int golesequipo1;
	int golesequipo2;
	int r;
	
	
	//CONSTRUCTOR CON SUS PARAMETROS CORRESPONDIENTES
	public Resultados(ArrayList<String> listacsv,ArrayList<String> listacsv2) {
		this.listacsv = listacsv;
		this.lineaPartido = lineaPartido;
		this.listacsv2 = listacsv2;
	}

	
	//METODO QUE HACE QUE SE COMPAREN LOS RESULTADOS
	public void leerLinea() {
		String[] separado;
		List<String> resultados= new ArrayList<String>();
		for (int i=0; i<listacsv2.size(); i++) { 	
			String lalinea = listacsv2.get(i);
			String[] sepa = lalinea.split(";");
			localPronostico.add(sepa[2]);
			visitantePronostico.add(sepa[6]);
			rondasPronostico.add(sepa[7]);
			ganador.add(sepa[3]);
			empate.add(sepa[4]);
			perdedor.add(sepa[5]);
		}

		//TABLA PARTIDOS
		for(int i=0; i<listacsv.size(); i++) {
			lineacsv = listacsv.get(i);
			separado = lineacsv.split(";");
			EquiposJuego.add(separado[1]);
			r= Integer.parseInt(separado[0]);
			rondas.add(r);
			golesequipo1 = Integer.parseInt(separado[2]);
			golesequipo2 = Integer.parseInt(separado[3]);
			localPartido.add(separado[1]);
			visitantePartido.add(separado[4]);
			idPartidos.add(separado[5]);
			
			if (golesequipo1>golesequipo2) {
				resultados.add("ganador");
			}
			if (golesequipo1==golesequipo2) {
				resultados.add("empate");
			}
			if (golesequipo1<golesequipo2) {
				resultados.add("perdedor");
			}
				
		}//FIN DEL FOR TABLA PARTIDOS
		
		
		//COMIENZO FOR TABLA PRONOSTICOS
		
		for (int i=0; i<listacsv2.size(); i++) {
			lineas = listacsv2.get(i);
			separado1 = lineas.split(";");
			jugadores.add(separado1[1]);
			String[] jugadoresSolos = lineas.split(";"); 
			lineaIdJugadores= lineas.split(";");
			idJugadores.add(lineaIdJugadores[0]);
		}
		

		//AL HABER EQUIPOS REPETIDOS EN LA COLUMNA LOCALES SE ELIMINA LA REPETICION
		
		Set<String> equiposRepetidos = new HashSet<String>(EquiposJuego);
		EquiposJuego.clear();
		EquiposJuego.addAll(equiposRepetidos);
		
		//AL HABER JUGADORES REPETIDOS EN LA COLUMNA JUGADORES SE ELIMINA LA REPETICION
		Set<String> jugadoresRepetidos = new HashSet<String>(jugadores);
		jugadores.clear();
		jugadores.addAll(jugadoresRepetidos);
		
		//AL HABER NUMEROS DE RONDAS REPETIDOS EN LA COLUMNA JUGADORES SE ELIMINA LA REPETICION
		Set<Integer> rondasRepetidas = new HashSet<Integer>(rondas);
		rondas.clear();	
		rondas.addAll(rondasRepetidas);
		
	
		//MENSIONANDO LOS PARTICIPANTES POR PANTALLA
		System.out.println("A CONTINUACION DAREMOS MENCION A LOS PARTICIPANTES : " + "\n");
			for (int j=0; j<jugadores.size(); j++) {
				System.out.println("Participante numero " + (j+1) + " <--> " + jugadores.get(j) + " de córdoba capital " +  "\n" );
			}
			System.out.println("SI EN CADA RONDA ACIERTAN A TODOS LOS PARTIDOS GANAN 2 PUNTOS ADICIONALES");
			System.out.println();
			System.out.println("SUS PUNTOS OBTENIDOS FUERON:");
			System.out.println();
			
			//RECORRIENDO LOS JUGADORES
			for (int x = 0; x<jugadores.size(); x++) {
				int puntos = 0;
				int mas=0;
				
				//RECORRIENDO LA TABLA PRONOSTICOS
				for (int i=0; i<listacsv2.size(); i++) { 	
					String lalinea = listacsv2.get(i);
					String[] sepa = lalinea.split(";");
					
					//HACIENDO LA COMPARACION Y AGREGANDO LOS PUNTOS  
					if (sepa[3].equals("x") && sepa[1].equals(jugadores.get(x)) ) {
						if(resultados.get(mas) == "ganador") {
							puntos = puntos+1;
						}
					}
					
					if (sepa[4].equals("x") && sepa[1].equals(jugadores.get(x))) {
						if(resultados.get(mas) == "empate") {
							puntos = puntos+1;
							}
					}
					
					if (sepa[5].equals("x") && sepa[1].equals(jugadores.get(x))) {
						if(resultados.get(mas) == "perdedor") {
							puntos = puntos+1;
							}
					}
					
					//REINICIANDO EL VALOR DE LA VARIABLE MAS PARA QUE VUELVA A COMENZAR EN LA PROXIMA VUELTA
					mas = mas +1;
					if(mas > 3) {
						mas = 0;
					}
					
				}//FIN DE RECORRIENDO LA TABLA PRONOSTICOS
				
				//SE GUARDAN EN UN MAPA LOS RESULTADOS PARA LOGRAR ENCONTRAR EL MAXIMO VALOR Y 
				//COLOCARLO EN LA PRIMERA POSICION.
				
				int bonus = 2;
				
				if (puntos == 2) {
					puntos = puntos + bonus;
					int pronostico = puntos - bonus;
					System.out.println("los puntos de " + jugadores.get(x) + " son " + puntos +
				            " Acertando la cantidad de " + pronostico + " pronosticos y resibe " + bonus + " puntos de bonus");
				}
				else {
					System.out.println("los puntos de " + jugadores.get(x) + " son " + puntos +
				            " Acertando la cantidad de " + puntos +"pronosticos");
				}
				puntosGuardados.put(jugadores.get(x), puntos);
				
				//IMPRIMIR LA CANTIDAD DE PUNTOS OBTENIDOS EN LA COMPETENCIA POR JUGADOR
				
				
				
			}//FIN DE //RECORRIENDO LOS JUGADORES
			
			// Ordenar el mapa por valor de mayor a menor
	        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
	        puntosGuardados.entrySet().stream()
	            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	            .forEachOrdered(h -> mapaOrdenado.put(h.getKey(), h.getValue()));

	        // Imprimir el mapa ordenado por valor
	        
	        System.out.println();
	        System.out.println();
	        System.out.println("RANKING DE JUGADORES ");
	        System.out.println();
	        
			for (Map.Entry<String, Integer> nombres : mapaOrdenado.entrySet()) {
				System.out.println(nombres.getKey() + " con " + nombres.getValue() + " puntos ");
			}
			
			
		}
	
	}
