package controller;

import model.Customer;
import model.Game;
import view.VideoGameView;

public class GameController {

	private Game model;
	private VideoGameView view;
	
	public GameController(Game model, VideoGameView view) {
		this.model = model;
		this.view = view;
	}
	
	public void create() {
		
	}
	
	public void read(String customerId) {
		model = Game.searchById(customerId);
		updateView();
	}
	
	public void update() {
		
	}
	
	public void destroy() {
		
	}

	public String getTitle() {
		return model.getTitle();
	}

	public void setTitle(String title) {
		model.setTitle(title);
	}

	public String getId() {
		return model.getId();
	}

	public void setId(String id) {
		model.setId(id);
	}

	public String getCompany() {
		return model.getCompany();
	}

	public void setCompany(String company) {
		model.setCompany(company);
	}

	public String getConsole() {
		return model.getConsole();
	}

	public void setConsole(String console) {
		model.setConsole(console);
	}

	public String getPrice() {
		return model.getPrice();
	}

	public void setPrice(String price) {
		model.setPrice(price);
	}
	
	public void updateView() {
		view.textArea1.setText("");
		view.textArea1.append(gameToString());
	}
	
	public String gameToString() {
		return "\nTitle: " + getTitle() + "\nID: " + getId() 
				+ "\nCompany: " + getCompany() + "\nConsole: " + getConsole()
				+ "\nPrice: "+ getPrice();
	}
}
