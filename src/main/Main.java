package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		String connectionURL = "JDBC:SQLITE:C:/Users/Robson Marinho/Downloads/sqlite/chinook.db";
		try {
			Connection conn = DriverManager.getConnection(connectionURL);
		
			System.out.println("Conectou ao SQLite");
		
		
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM genres;");
			ResultSet res = stm.executeQuery();
			
			while (res.next()) {
				
				Integer genreId = res.getInt("GenreId");
				String genreName = res.getString("Name");
				
				System.out.println(
						genreId + " | " + genreName 
				);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
