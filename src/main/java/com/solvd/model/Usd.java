package com.solvd.model;

import java.math.*;

public class Usd {
	    private Integer id;
	    private Integer banknote;
	    private BigDecimal quantity;


	    public Usd() {

	    }

	    public Usd(Integer id, Integer banknote, BigDecimal quantity) {

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

		public BigDecimal getQuantity() {
			return quantity;
		}

		public void setQuantity(BigDecimal quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Banknote : " + getBanknote() + 
					"Quantity : " + getQuantity();
		}

}
