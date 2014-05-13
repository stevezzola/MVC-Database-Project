package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import model.Purchase;
import view.VideoGameView;

public class PurchaseController {

	private Purchase model;
	private VideoGameView view;
	
	
	public PurchaseController(Purchase model, VideoGameView view) {
		this.model = model;
		this.view = view;
	}
	
	public void create(HashMap<String, String> args) {
		model = new Purchase(args);
		model.save();
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(model);
		updateView(purchases);
		System.out.println("New Purchase Saved!");
	}
	
	public void read(HashMap<String, String> args) {
		ArrayList<Purchase> purchases;
		if (args.get("customerId").equals("") && args.get("gameId").equals("")) {
			purchases = Purchase.selectAll();
		}
		else {
			purchases = Purchase.where(args);
		}
		updateView(purchases);
	}
	
	public void update(HashMap<String, String> args) {
		HashMap<String, String> keys = new HashMap<String, String>();
		keys.put("customerId", args.get("customerId"));
		keys.put("gameId", args.get("gameId"));
		ArrayList<Purchase> purchases; 
		purchases = Purchase.where(keys);
		for (int i = 0; i < purchases.size(); i++) {
			model = purchases.get(i);
			setPurchaseDate((args.get("purchaseDate")));
			setRating(Double.parseDouble(args.get("rating")));
			model.save();
		}
		System.out.println("Game Updated!");
	}
	
	public void destroy(HashMap<String, String> args) {
		ArrayList<Purchase> purchases; 
		purchases = Purchase.where(args);
		for (int i = 0; i < purchases.size(); i++) {
			model = purchases.get(i);
			model.delete();
		}
		purchases = new ArrayList<Purchase>();
		System.out.println("Purchase Deleted!");
	}

	public String getCustomerId() {
		return model.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		model.setCustomerId(customerId);
	}

	public String getGameId() {
		return model.getGameId();
	}

	public void setGameId(String gameId) {
		model.setGameId(gameId);
	}

	public String getPurchaseDate() {
		return model.getPurchaseDate();
	}

	public void setPurchaseDate(String purchaseDate) {
		model.setPurchaseDate(purchaseDate);
	}

	public double getRating() {
		return model.getRating();
	}

	public void setRating(double rating) {
		model.setRating(rating);
	}
	
	public void updateView(ArrayList<Purchase> purchases) {
		//System.out.println(customerToString());
		DefaultTableModel tableModel = (DefaultTableModel) view.table.getModel();
		tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(view.purchaseColumns);
		for (int i = 0; i < purchases.size(); i++) {
			model = purchases.get(i);
			if (!(model == null)) {
				String[] row = {getCustomerId(), getGameId(), 
						getPurchaseDate(), Double.toString(getRating())};
				tableModel.addRow(row);
			}
		}
	}
}
