package model;

import java.sql.*;

import app.VideoGameDemo;

public class Customer {
	private String customerName;
	private String id;
	private String gender;
	private int age;
	private String birthDate;
	private String playLevel;
	
	public Customer () throws SQLException {
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
		VideoGameDemo.stmt.executeUpdate(sql);
	}
	
	public static Customer searchById(String id) {
		Customer customer = null;
		try {
			customer = new Customer();
			String sql = "SELECT * FROM Customer WHERE id = " + id;
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			rs.next();
			customer.setCustomerName(rs.getString("customerName"));
			customer.setId(rs.getString("id"));
			customer.setGender(rs.getString("gender"));
			customer.setAge(rs.getInt("age"));
			customer.setBirthDate(rs.getString("birthDate"));
			customer.setPlayLevel(rs.getString("playLevel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
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