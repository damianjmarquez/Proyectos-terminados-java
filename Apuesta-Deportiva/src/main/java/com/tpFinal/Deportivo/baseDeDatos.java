package com.tpFinal.Deportivo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class baseDeDatos {
	
	ArrayList<String> lista = new ArrayList<String>();
	ArrayList<String> listaPronostico = new ArrayList<String>();
	
	public ArrayList<String> bdPartidos() throws SQLException {
		
		String url = "jdbc:mysql://localhost/";
		String db = "deportivo";
		String usuario = "root";
		String contraseña= "";
		Connection conn = null;
		conn = DriverManager.getConnection( url+ db , usuario,contraseña);
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from partidos");
		while (rs.next()) {
			
			lista.add(rs.getString("ronda") + ";" + 
			          rs.getString("local") + ";" + 
					  rs.getString("Glocal") + ";" + 
			          rs.getString("Gvisitante") + ";" +
			          rs.getString("visitante") + ";" +
					  rs.getString("Id"));
				
		}
		conn.close();
		return lista; 
	}
	
	
	
	public ArrayList<String> bdPronostico() throws SQLException {
		
		
		String url = "jdbc:mysql://localhost/";
		String db = "deportivo";
		String usuario = "root";
		String contraseña= "";
		Connection conn = null;
		conn = DriverManager.getConnection( url + db,usuario,contraseña);
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM deportivo.pronosticos;");
		
		while (rs.next()) {
			listaPronostico.add(rs.getString("id") + ";" + 
			          rs.getString("jugadores") + ";" + 
					  rs.getString("Local") + ";" + 
			          rs.getString("Ganador") + ";" +
			          rs.getString("Empate") + ";" +
					  rs.getString("Perdedor") + ";" +
					  rs.getString("Visitante") + ";" +
			          rs.getString("Ronda"));
		
		}
		conn.close();
		return listaPronostico; 
	}

}
