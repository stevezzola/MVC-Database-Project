package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
		age = Integer.parseInt(params.get("age"));
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
			VideoGameDemo.stmt.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public static Customer find(String id) {
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Customer WHERE id = " + id;
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