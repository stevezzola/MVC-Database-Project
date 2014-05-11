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
		try { rating = Double.parseDouble("rating"); }
		catch (NumberFormatException e) {}
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS Purchase " +
				"(customerId char(8), " +
				"gameId char(10) not null, " +
				"purchaseDate date, " +
				"rating integer, " +
				"primary key (customerId, gameId), " +
				"foreign key (customerId) references Customer (id)," +
				"foreign key (gameId) references Game (id)" +
				")";
		try {
			System.out.println("Executing query: " + sql);
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Purchase find(String customerId, String gameId) {
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Game WHERE customerId = '"
					+ customerId + "'" + " AND " + "gameId = '" + gameId + "'";
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			if (rs.next()) {
				params.put("customerId", rs.getString("customerId"));
				params.put("gameId", rs.getString("gameId"));
				params.put("purchaseDate", rs.getString("purchaseDate"));
				params.put("rating", String.valueOf(rs.getDouble("rating")));
			} else {
				return null;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return new Purchase(params);
	}
	
	public static ArrayList<Purchase> where(String[][] args) {
		HashMap<String, String> hArgs = new HashMap<String, String>();
		for (String[] row : args) {
			hArgs.put(row[0], row[1]);
		}
		return where(hArgs);
	}
	
	public static ArrayList<Purchase> where(HashMap<String, String> args) {
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		if (args.isEmpty()) return list;
		String sql = "SELECT * FROM Purchase WHERE ";
		Iterator<Map.Entry<String, String>> it = args.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
			if (pair.getValue() == null || pair.getValue().isEmpty()) continue;
			sql += ("Purchase." + pair.getKey() + " = '" + pair.getValue() + "' AND ");
		}
		sql = sql.substring(0, sql.lastIndexOf(" AND "));
		try {
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			HashMap<String, String> params = new HashMap<String, String>();
			while (rs.next()) {
				params.put("customerId", rs.getString("customerId"));
				params.put("gameId", rs.getString("gameId"));
				params.put("purchaseDate", rs.getString("purchaseDate"));
				params.put("rating", String.valueOf(rs.getDouble("rating")));
				list.add(new Purchase(params));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return list;
	}
	
	public boolean save() {
		if (this.isNewRecord()) {
			String sql = "INSERT INTO Purchase (customerId, gameId, purchaseDate, rating) " + 
					"VALUES ('" + customerId + "', " + "'" + gameId + "', " + "'" + purchaseDate + "', " +
					rating + "')";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) { 
				e.printStackTrace();
				return false; 
			}
			return true;
		} else {
			String sql = "UPDATE Purchase SET" +
					" customerId = '" + customerId + "', " +
					" gameId = '" + gameId + "', " +
					" purchaseDate = '" + purchaseDate + "', " +
					" rating = " + rating + ", " +
					" WHERE customerId = '" + customerId + "'" +
					" AND gameId = '" + gameId + "'";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}
	
	public boolean delete() {
		if (!isNewRecord()) {
			String sql = "DELETE FROM Game WHERE customerId = '"
					+ customerId + "'" + " AND " + "gameId = '" + gameId + "'";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else return false;
		return true;
	}
	
	private boolean isNewRecord() {
		return find(customerId, gameId) == null;
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
