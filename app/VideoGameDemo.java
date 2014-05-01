package app;

import java.sql.*;

import controller.CustomerController;
import controller.GameController;
import controller.PurchaseController;
import view.VideoGameView;
import model.Customer;
import model.Game;
import model.Purchase;

public class VideoGameDemo {
	
	public static Statement stmt;

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			final String url = "jdbc:mysql://localhost:3306/VideoGameDatabase";
			final String username = "root";
			final String password = "qwerty";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!");
			stmt = conn.createStatement();
			
			Customer customerModel = new Customer();
			Game gameModel = new Game();
			Purchase purchaseModel = new Purchase();
			VideoGameView view = new VideoGameView();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}