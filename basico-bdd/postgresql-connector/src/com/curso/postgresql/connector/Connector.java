package com.curso.postgresql.connector;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase de conexion a una base de datos PostgreSQL
 * @author ropherpanama
 *
 */
public class Connector {

	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:postgresql://localhost:5432/database";
			String user = "user";
			String pass = "secret";
			return DriverManager.getConnection(dbURL, user, pass);
		}catch(Exception e) {
			System.out.println("Error al obtener conexion: " + e.getMessage());
		}
		return null;
	}
}
