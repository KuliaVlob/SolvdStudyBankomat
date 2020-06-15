package com.solvd.dao;

import com.solvd.model.Usd;

import java.util.List;

/**
 * DAO interface, describes methods to access data from database table "Usd"
 * 
 * @author Iryna Iemelianova
 */
public interface IUsdDAO {

	Usd getQuantityByBanknoteUSD(Integer banknote);

	Usd getQuantityUSD(String quantity);

	List<Usd> getAvailableBanknoteUSD (String quantity);

	
}
