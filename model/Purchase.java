package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
			System.out.println("Executing query: " + sql);
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
	
	public static ArrayList<Purchase> where(HashMap<String, String> args) {
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		if (args.isEmpty()) return list;
		String sql = "SELECT * FROM Purchase WHERE ";
		Iterator<Map.Entry<String, String>> it = args.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
			sql += ("Purchase." + pair.getKey() + " = " + pair.getValue() + " AND ");
		}
		sql = sql.substring(0, sql.lastIndexOf(" AND "));
		try {
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			HashMap<String, String> params = new HashMap<String, String>();
			while (rs.next()) {
				params.put("PurchaseName", rs.getString("PurchaseName"));
				params.put("id", rs.getString("id"));
				params.put("gender", rs.getString("gender"));
				params.put("age", String.valueOf(rs.getInt("age")));
				params.put("birthDate", rs.getString("birthDate"));
				params.put("playLevel", rs.getString("playLevel"));
				list.add(new Purchase(params));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return list;
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
