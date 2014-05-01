package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.VideoGameDemo;

public class Game {
	private String title;
	private String id;
	private String company;
	private String console;
	private String price;
	
	public Game () throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS Game " +
				"(title varChar(50), " +
				"id char(10) not null, " +
				"company varChar(50), " +
				"console varChar(5), " +
				"price varChar(8), " +
				"primary key (id)" +
				")";
		VideoGameDemo.stmt.executeUpdate(sql);
	}
	
	public static Game searchById(String id) {
		Game game = null;
		try {
			game = new Game();
			String sql = "SELECT * FROM Game WHERE id = '" + id + "'";
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			rs.next();
			game.setTitle(rs.getString("title"));
			game.setId(rs.getString("id"));
			game.setCompany(rs.getString("company"));
			game.setConsole(rs.getString("console"));
			game.setPrice(rs.getString("price"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getConsole() {
		return console;
	}
	
	public void setConsole(String console) {
		this.console = console;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
}
