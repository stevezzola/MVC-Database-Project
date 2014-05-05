package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.Game;
import model.Purchase;
import view.VideoGameView;

public class VideoGameDemo {
	
	public static Statement stmt;
	public static final String OS = System.getProperty("os.name");

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/VideoGameDatabase";
			String username = "root";
			String password = "qwerty";
			
			if (OS.startsWith("Linux")) {
				url = "jdbc:mysql://localhost:3306/video_game_database";
				username = "vgd";
			}
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!");
			stmt = conn.createStatement();
			
			Customer.createTable();
			Game.createTable();
			Purchase.createTable();
			new VideoGameView();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}