package controller;

import model.Customer;
import view.VideoGameView;

public class CustomerController {
	private Customer model;
	private VideoGameView view;
	
	public CustomerController(Customer model, VideoGameView view) {
		this.model = model;
		this.view = view;
	}
	
	public void create() {
		
	}
	
	public void read(String customerId) {
		model = Customer.find(customerId);
		updateView();
	}
	
	public void update() {
		
	}
	
	public void destroy() {
		
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
	
	public void updateView() {
		view.jTextArea1.setText("");
		view.jTextArea1.append(customerToString());
	}
	
	public String customerToString() {
		return "\nName: " + getCustomerName() + "\nID: " + getId() 
				+ "\nGender: " + getGender() + "\nAge: " + getAge()
				+ "\nBirthday: "+ getBirthDate() + "\nPlay Level: " + getPlayLevel();
	}
}
