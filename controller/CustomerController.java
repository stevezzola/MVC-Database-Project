package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import model.Customer;
import view.VideoGameView;

public class CustomerController {
	private Customer model;
	private VideoGameView view;
	
	public CustomerController(Customer model, VideoGameView view) {
		this.model = model;
		this.view = view;
	}
	
	public void create(HashMap<String, String> args) {
		model = new Customer(args);
		model.save();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(model);
		updateView(customers);
		System.out.println("New Customer Saved!");
	}
	
	public void read(String customerId) {
		model = Customer.find(customerId);
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(model);
		updateView(customers);
	}
	
	public void read(HashMap<String, String> args) {
		ArrayList<Customer> customers = Customer.where(args);
		updateView(customers);
	}
	
	public void update(HashMap<String, String> args) {
		model = Customer.find(args.get("id"));
		setCustomerName(args.get("customerName"));
		setGender(args.get("gender"));
		setAge(Integer.parseInt(args.get("age")));
		setBirthDate(args.get("birthDate"));
		setPlayLevel(args.get("playLevel"));
		model.save();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(model);
		System.out.println("Customer Updated!");
	}
	
	public void destroy(HashMap<String, String> args) {
		model = Customer.find(args.get("id"));
		model.delete();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(model);
		updateView(customers);
		System.out.println("Customer Deleted!");
	}
	
	public String getCustomerName() {
		return model.getCustomerName();
	}
	
	public void setCustomerName(String name) {
		model.setCustomerName(name);
	}
	
	public String getId() {
		return model.getId();
	}
	
	public void setId(String id) {
		model.setId(id);
	}
	
	public String getGender() {
		return model.getGender();
	}
	
	public void setGender(String gender) {
		model.setGender(gender);
	}
	
	public int getAge() {
		return model.getAge();
	}
	
	public void setAge(int age) {
		model.setAge(age);
	}
	
	public String getBirthDate() {
		return model.getBirthDate();
	}
	
	public void setBirthDate(String birthDate) {
		model.setBirthDate(birthDate);
	}
	
	public String getPlayLevel() {
		return model.getPlayLevel();
	}
	
	public void setPlayLevel(String playLevel) {
		model.setPlayLevel(playLevel);
	}
	
	public void updateView(ArrayList<Customer> customers) {
		//System.out.println(customerToString());
		DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(view.customerColumns);
		for (int i = 0; i < customers.size(); i++) {
			model = customers.get(i);
			if (!(model == null)) {
				String[] row = {getCustomerName(), getId(), getGender(), 
						Integer.toString(getAge()), getBirthDate(), getPlayLevel()};
				tableModel.addRow(row);
			}
		}
	}
	
	public String customerToString() {
		return "\n Name: " + getCustomerName() + "\n ID: " + getId() 
				+ "\n Gender: " + getGender() + "\n Age: " + getAge()
				+ "\n Birthday: "+ getBirthDate() + "\n Play Level: " + getPlayLevel();
	}
}
