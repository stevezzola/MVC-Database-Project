package controller;

import model.Purchase;
import view.VideoGameView;

public class PurchaseController {

	private Purchase model;
	private VideoGameView view;
	
	public PurchaseController(Purchase model, VideoGameView view) {
		this.model = model;
		this.view = view;
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
	
	public void updateView() {
		
	}
}
