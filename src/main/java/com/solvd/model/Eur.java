package com.solvd.model;

/**
 * Model class for data base table "Eur"
 * 
 * @author Iryna Iemelianova
 */
public class Eur {
	    private Integer id;
	    private Integer banknote;
	    private String quantity;


	    public Eur() {

	    }


	public Integer getBanknote() {
		return banknote;
	}

	public void setBanknote(Integer banknote) {
		this.banknote = banknote;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Banknote : " + getBanknote();
	}


}
