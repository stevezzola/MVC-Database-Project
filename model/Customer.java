package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
	
	private static class Fuzzy {
		public static HashSet<String> words = new HashSet<String>(Arrays.asList("customerName"));
	}
	
	public Customer() {
	}
	
	public Customer (HashMap<String, String> params) { //Customer constructor, initializes variables
		customerName = params.get("customerName");
		id = params.get("id");
		gender = params.get("gender");
		try { age = Integer.parseInt(params.get("age")); }
		catch (NumberFormatException e) {}
		birthDate = params.get("birthDate");
		playLevel = params.get("playLevel");
	}

	public static void createTable() { //Creates table if it does not exist
		String sql = "CREATE TABLE IF NOT EXISTS Customer " +
				"(customerName varChar(50), " +
				"id char(8) not null, " +
				"gender varchar(6), " +
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
	
	public static Customer find(String id) { //finds Customer in database with specified id
		HashMap<String, String> params = new HashMap<String, String>();
		try {
			String sql = "SELECT * FROM Customer WHERE id = '" + id + "'";
			System.out.println("Executing query: " + sql);
			ResultSet rs = VideoGameDemo.stmt.executeQuery(sql);
			if (rs.next()) {
				params.put("customerName", rs.getString("customerName"));
				params.put("id", rs.getString("id"));
				params.put("gender", rs.getString("gender"));
				params.put("age", String.valueOf(rs.getInt("age")));
				params.put("birthDate", rs.getString("birthDate"));
				params.put("playLevel", rs.getString("playLevel"));
			} else {
				return null;
			}
		} catch (Exception e) { e.printStackTrace(); }
		return new Customer(params);
	}
	
	public static ArrayList<Customer> where(HashMap<String, String> args) { //finds all Customers that match specified parameters
		ArrayList<Customer> list = new ArrayList<Customer>();
		if (args.isEmpty()) return list;
		String sql = "SELECT * FROM Customer WHERE ";
		Iterator<Map.Entry<String, String>> it = args.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
			if (pair.getValue() == null || pair.getValue().isEmpty()) continue;
			if (Fuzzy.words.contains(pair.getKey()))
				sql += ("LOWER(Customer." + pair.getKey() + ") LIKE LOWER('%" + pair.getValue() + "%') AND "); //Allows for inexact values
			else
				sql += ("Customer." + pair.getKey() + " = '" + pair.getValue() + "' AND ");
			
		}
		int index = sql.lastIndexOf(" AND ");
		if (index != -1) sql = sql.substring(0, index);
		else return list;
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
	
	public static ArrayList<Customer> selectAll() {  //returns ALL Customers in database
		ArrayList<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM Customer";
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
	
	public boolean save() { //checks if record is new: saves if true, updates if false
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
	
	public boolean delete() { //deletes Customer with specified id
		if (!isNewRecord()) {
			String sql = "DELETE FROM Customer WHERE id = '" + id + "'";
			System.out.println("Executing query: " + sql);
			try { VideoGameDemo.stmt.executeUpdate(sql); }
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else return false;
		return true;
	}
	
	private boolean isNewRecord() { //looks for a specific record in database. returns true if found, false if not
		return find(id) == null;
	}
	
	
	//Getters and Setters
	
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