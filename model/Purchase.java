package model;

import java.sql.SQLException;

import app.VideoGameDemo;

public class Purchase {

	private String customerId;
	private String gameId;
	private String purchaseDate;
	private double rating;
	
	public Purchase () throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Purchase " +
				"(customerId char(8), " +
				"gameId char(10) not null, " +
				"purchaseDate date, " +
				"rating decimal(2,1), " +
				"primary key (customerId, gameId), " +
				"foreign key (customerId) references Customer (id)," +
				"foreign key (gameId) references Game (id)" +
				")";
		VideoGameDemo.stmt.executeUpdate(sql);
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
