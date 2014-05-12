package controller;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public void create(HashMap<String, String> args) {
		model = new Game(args);
		model.save();
		System.out.println("New Game Saved!");
	}
	
	public void read(String customerId) {
		model = Game.find(customerId);
		updateView();
	}
	
	public void read(HashMap<String, String> args) {
		ArrayList<Game> games = Game.where(args);
		for (int i = 0; i < games.size(); i++) {
			model = games.get(i);
			updateView();
		}
	}
	
	public void update(HashMap<String, String> args) {
		model = Game.find(args.get("id"));
		setTitle(args.get("title"));
		setCompany(args.get("company"));
		setConsole((args.get("console")));
		setPrice(args.get("price"));
		model.save();
		updateView();
		System.out.println("Game Updated!");
	}
	
	public void destroy(HashMap<String, String> args) {
		model = Game.find(args.get("id"));
		model.delete();
		updateView();
		System.out.println("Game Deleted!");
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
		System.out.println(gameToString());
	}
	
	public String gameToString() {
		return "\n Title: " + getTitle() + "\n ID: " + getId() 
				+ "\n Company: " + getCompany() + "\n Console: " + getConsole()
				+ "\n Price: "+ getPrice();
	}
}
