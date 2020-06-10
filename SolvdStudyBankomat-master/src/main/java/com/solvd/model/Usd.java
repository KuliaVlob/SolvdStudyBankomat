package com.solvd.model;

import java.math.*;

public class Usd {
	    private Integer id;
	    private Integer banknote;
	    private Integer quantity;


	    public Usd() {

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
