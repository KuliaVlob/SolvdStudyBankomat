package com.solvd.dao;

import java.util.List;

import com.solvd.model.Eur;

public interface IEurDAO {

	Eur getQuantityByBanknoteEUR(Integer banknote);

	Eur getQuantityEUR(String quantity);

	void updateQuantityByBanknoteEUR(Eur entity);

	List<Eur> getAvailableBanknoteEUR (String quantity);
	
	void getBanknoteEUR(Eur entity);

}
