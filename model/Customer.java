package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import app.VideoGameDemo;

public class Customer {
	private String customerName;
	private String id;
	private String gender;
	private int age;
	private String birthDate;
	private String playLevel;
	
	public Customer() {
	}
	
	public Customer (HashMap<String, String> params) {
		customerName = params.get("customerName");
		id = params.get("id");
		gender = params.get("gender");
		try { age = Integer.parseInt(params.get("age")); }
		catch (NumberFormatException e) {}
		birthDate = params.get("birthDate");
		playLevel = params.get("playLevel");
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS Customer " +
				"(customerName varChar(50), " +
				"id char(8) not null, " +
				"gender char(1), " +
				"age integer, " +
				"birthDate date, " +
				"playLevel varChar(12), " +
				"primary key (id)" +
				")";
		try {
			System.out.println("Executing query: " + sql);
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Customer find(String id) {
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Customer WHERE id = " + id;
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			if (rs.next()) {
				params.put("customerName", rs.getString("customerName"));
				params.put("id", rs.getString("id"));
				params.put("gender", rs.getString("gender"));
				params.put("age", String.valueOf(rs.getInt("age")));
				params.put("birthDate", rs.getString("birthDate"));
				params.put("playLevel", rs.getString("playLevel"));
			}
		} catch (Exception e) { e.printStackTrace(); }
		return new Customer(params);
	}
	
	public static ArrayList<Customer> where(HashMap<String, String> args) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		if (args.isEmpty()) return list;
		String sql = "SELECT * FROM Customer WHERE ";
		Iterator<Map.Entry<String, String>> it = args.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
			sql += ("Customer." + pair.getKey() + " = " + pair.getValue() + " AND ");
		}
		sql = sql.substring(0, sql.lastIndexOf(" AND "));
		try {
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			HashMap<String, String> params = new HashMap<String, String>();
			while (rs.next()) {
				params.put("customerName", rs.getString("customerName"));
				params.put("id", rs.getString("id"));
				params.put("gender", rs.getString("gender"));
				params.put("age", String.valueOf(rs.getInt("age")));
				params.put("birthDate", rs.getString("birthDate"));
				params.put("playLevel", rs.getString("playLevel"));
				list.add(new Customer(params));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return list;
	}
	
	public boolean save() {
		if (this.isNewRecord()) {
			String sql = "INSERT INTO Customer (customerName, id, gender, age, birthDate, playLevel) " + 
					"VALUES ('" + customerName + "', " + "'" + id + "', " + "'" + gender + "', " +
					age + ", " + "'" + birthDate + "', " + "'" + playLevel + "')";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) { 
				e.printStackTrace();
				return false; 
			}
			return true;
		} else {
			String sql = "UPDATE Customer SET" +
					" customerName = '" + customerName + "', " +
					" id = '" + id + "', " +
					" gender = '" + gender + "', " +
					" age = " + age + ", " +
					" birthDate = '" + birthDate + "', " +
					" playLevel = '" + playLevel + "'" +
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
	
	private boolean isNewRecord() {
		String sql = "SELECT * FROM Customer WHERE id = " + id;
		try {
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			return !rs.next();
		} catch (SQLException e) { e.printStackTrace(); }
		return false;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getPlayLevel() {
		return playLevel;
	}
	
	public void setPlayLevel(String playLevel) {
		this.playLevel = playLevel;
	}
	
}