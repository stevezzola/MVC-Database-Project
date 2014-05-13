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
	
	public void read(HashMap<String, String> args) {
		ArrayList<Purchase> purchases = Purchase.where(args);
		updateView(purchases);
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

	public void setRating(int rating) {
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
