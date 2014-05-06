package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import app.VideoGameDemo;

public class Game {
	private String title;
	private String id;
	private String company;
	private String console;
	private String price;
	
	public Game() {
	}
	
	public Game(HashMap<String, String> params) {
		title = params.get("title");
		id = params.get("id");
		company = params.get("company");
		console = params.get("console");
		price = params.get("price");
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS Game " +
				"(title varChar(50), " +
				"id char(10) not null, " +
				"company varChar(50), " +
				"console varChar(5), " +
				"price varChar(8), " +
				"primary key (id)" +
				")";
		try {
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Game find(String id) {
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
		return new Game(params);
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
