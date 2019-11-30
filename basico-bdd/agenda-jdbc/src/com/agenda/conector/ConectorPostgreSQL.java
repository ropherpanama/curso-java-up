package com.agenda.conector;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorPostgreSQL {

	private ConectorPostgreSQL() {}
	
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:postgresql://localhost:5432/contacts";
			String user = "postgres";
			String pass = "cursojava19";
			
			return DriverManager.getConnection(dbURL, user, pass);
		} catch(Exception e) {
			System.out.println("Hubo un error en la conexion : " + e.getMessage());
			return null;
		}
	}
}
