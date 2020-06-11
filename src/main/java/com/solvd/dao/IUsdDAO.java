package com.solvd.dao;

import com.solvd.model.Usd;

public interface IUsdDAO {

	Usd getQuantityByBanknoteUSD(Integer banknote);

	Usd getQuantityUSD(Integer quantity);

	void updateQuantityByBanknoteUSD(Usd entity);

}
