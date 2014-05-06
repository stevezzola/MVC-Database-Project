package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import app.VideoGameDemo;

public class Purchase {

	private String customerId;
	private String gameId;
	private String purchaseDate;
	private double rating;
	
	public Purchase () {
	}
	
	public Purchase(HashMap<String, String> params) {
		customerId = params.get("customerId");
		gameId = params.get("gameId");
		purchaseDate = params.get("purchaseDate");
		rating = Double.parseDouble("rating");
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS Purchase " +
				"(customerId char(8), " +
				"gameId char(10) not null, " +
				"purchaseDate date, " +
				"rating decimal(2,1), " +
				"primary key (customerId, gameId), " +
				"foreign key (customerId) references Customer (id)," +
				"foreign key (gameId) references Game (id)" +
				")";
		try {
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Purchase find(String id) {
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Game WHERE id = '" + id + "'";
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			if (rs.next()) {
				params.put("title", rs.getString("title"));
				params.put("id", rs.getString("id"));
				params.put("company", rs.getString("company"));
				params.put("console", rs.getString("console"));
				params.put("price", rs.getString("price"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return new Purchase(params);
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
