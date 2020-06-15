package com.solvd.dao;

import com.solvd.model.Usd;

import java.util.List;

public interface IUsdDAO {

	Usd getQuantityByBanknoteUSD(Integer banknote);

	Usd getQuantityUSD(String quantity);

	List<Usd> getAvailableBanknoteUSD (String quantity);

	
}
