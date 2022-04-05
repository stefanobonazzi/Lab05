package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=stefanobonazzi&password=psw2810";

	public static Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			return connection;
		} catch (SQLException e) {
			System.err.println("Errore nella connessione!");
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
	
}