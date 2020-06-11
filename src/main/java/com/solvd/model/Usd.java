package com.solvd.model;

public class Usd {

	    private Integer id;
	    private Integer banknote;
	    private String quantity;


	    public Usd() {

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
