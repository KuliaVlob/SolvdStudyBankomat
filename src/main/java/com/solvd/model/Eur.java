package com.solvd.model;

import java.math.BigDecimal;

public class Eur {
	    private Integer id;
	    private Integer banknote;
	    private Integer quantity;


	    public Eur() {

	    }

	    public Eur(Integer id, Integer banknote, Integer quantity) {

	        this.banknote = id;
	        this.banknote = banknote;
	        this.quantity = quantity;
	       
	    }

		public Integer getBanknote() {
			return banknote;
		}

		public void setBanknote(Integer banknote) {
			this.banknote = banknote;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Banknote : " + getBanknote() + 
					"Quantity : " + getQuantity();
		}

}


