package com.solvd.dao;

import java.util.List;

import com.solvd.model.Eur;

/**
 * DAO interface, describes methods to access data from database table "Eur"
 * 
 * @author Iryna Iemelianova
 */
public interface IEurDAO {

	Eur getQuantityByBanknoteEUR(Integer banknote);

	Eur getQuantityEUR(String quantity);

	List<Eur> getAvailableBanknoteEUR (String quantity);
	
}
