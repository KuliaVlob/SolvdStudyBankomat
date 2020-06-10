package com.solvd.dao;

import com.solvd.model.Eur;

public interface IEurDAO {
	
	    Eur getQuantityByBanknoteEUR(Integer banknote);
	    
	    void updateQuantityByBanknoteEUR(Eur entity);

}
