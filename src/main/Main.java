package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// Insere o Db de conexão e o caminho onde se encontra o arquivo
		String connectionURL = "JDBC:SQLITE:C:/Users/Robson Marinho/Downloads/sqlite/chinook.db";
		try {
			Connection conn = DriverManager.getConnection(connectionURL);

			System.out.println("Conectou ao SQLite");
			// Query na tabela genres
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM genres;");
			ResultSet res = stm.executeQuery();

			while (res.next()) {

				Integer genreId = res.getInt("GenreId");
				String genreName = res.getString("Name");
				// Exibe as colunas
				System.out.println(genreId + " | " + genreName);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
