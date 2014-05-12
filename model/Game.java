package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
				"console varChar(10), " +
				"price decimal(5,2), " +
				"primary key (id)" +
				")";
		try {
			System.out.println("Executing query: " + sql);
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Game find(String id) {
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Game WHERE id = '" + id + "'";
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			if (rs.next()) {
				params.put("title", rs.getString("title"));
				params.put("id", rs.getString("id"));
				params.put("company", rs.getString("company"));
				params.put("console", rs.getString("console"));
				params.put("price", rs.getString("price"));
			} else {
				return null;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return new Game(params);
	}
	
	public static ArrayList<Game> where(String[][] args) {
		HashMap<String, String> hArgs = new HashMap<String, String>();
		for (String[] row : args) {
			hArgs.put(row[0], row[1]);
		}
		return where(hArgs);
	}
	
	public static ArrayList<Game> where(HashMap<String, String> args) {
		ArrayList<Game> list = new ArrayList<Game>();
		if (args.isEmpty()) return list;
		String sql = "SELECT * FROM Game WHERE ";
		Iterator<Map.Entry<String, String>> it = args.entrySet().iterator();
		if (!it.hasNext()) return list;
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
			if (pair.getValue() == null || pair.getValue().isEmpty()) continue;
			sql += ("Game." + pair.getKey() + " = '" + pair.getValue() + "' AND ");
		}
		int index = sql.lastIndexOf(" AND ");
		if (index != -1) sql = sql.substring(0, index);
		try {
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			HashMap<String, String> params = new HashMap<String, String>();
			while (rs.next()) {
				params.put("title", rs.getString("title"));
				params.put("id", rs.getString("id"));
				params.put("company", rs.getString("company"));
				params.put("console", rs.getString("console"));
				params.put("price", rs.getString("price"));
				list.add(new Game(params));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return list;
	}
	
	public boolean save() {
		if (this.isNewRecord()) {
			String sql = "INSERT INTO Game (title, id, company, console, price) " + 
					"VALUES ('" + title + "', " + "'" + id + "', " + "'" + company + "', '" +
					console + "', " + "'" + price + "')";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) { 
				e.printStackTrace();
				return false; 
			}
			return true;
		} else {
			String sql = "UPDATE Game SET" +
					" title = '" + title + "', " +
					" id = '" + id + "', " +
					" company = '" + company + "', " +
					" console = '" + console + "', " +
					" price = '" + price + "'" +
					" WHERE id = '" + id + "'";
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
			String sql = "DELETE FROM Game WHERE id = '" + id + "'";
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
		return find(id) == null;
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
