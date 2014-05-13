package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import model.Game;
import view.VideoGameView;

public class GameController {

	private Game model;
	private VideoGameView view;
	
	public GameController(Game model, VideoGameView view) {
		this.model = model;
		this.view = view;
	}
	
	public void create(HashMap<String, String> args) { //Sends arguments from View to Model for creation in database
		model = new Game(args);
		model.save();
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(model);
		updateView(games);
		System.out.println("New Game Saved!");
	}
	
	public void read(String customerId) { //Reads data from Model, requested by View (uses id only)
		model = Game.find(customerId);
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(model);
		updateView(games);
	}
	
	public void read(HashMap<String, String> args) { //Reads data from Model, requested by View (uses all arguments)
		ArrayList<Game> games;
		if (args.get("title").equals("") && args.get("id").equals("") 
				&& args.get("company").equals("") && args.get("console").equals("") 
				&& args.get("price").equals("")) {
			games = Game.selectAll();
		}
		else {
			games = Game.where(args);
		}
		updateView(games);
	}
	
	public void update(HashMap<String, String> args) { //Updates data in Model with new info retrieved from GUI
		model = Game.find(args.get("id"));
		setTitle(args.get("title"));
		setCompany(args.get("company"));
		setConsole((args.get("console")));
		setPrice(args.get("price"));
		model.save();
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(model);
		System.out.println("Game Updated!");
	}
	
	public void destroy(HashMap<String, String> args) { //deletes data in Model based on which JTable row is selected 
		model = Game.find(args.get("id"));
		model.delete();
		ArrayList<Game> games = new ArrayList<Game>();
		games.add(model);
		System.out.println("Game Deleted!");
	}

	//Getters and Setters
	
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
	
	public void updateView(ArrayList<Game> games) {
		//System.out.println(gameToString());
		DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
		tableModel.setColumnIdentifiers(view.gameColumns);
		tableModel.setRowCount(0);
		for (int i = 0; i < games.size(); i++) {
			model = games.get(i);
			String[] row = {getTitle(), getId(), getCompany(), 
					getConsole(), getPrice()};
			tableModel.addRow(row);
		}
	}
	
	public String gameToString() {
		return "\n Title: " + getTitle() + "\n ID: " + getId() 
				+ "\n Company: " + getCompany() + "\n Console: " + getConsole()
				+ "\n Price: "+ getPrice();
	}
}
