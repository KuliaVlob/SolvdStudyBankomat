package com.solvd.dao;

import com.solvd.model.Eur;

public interface IEurDAO {

	Eur getQuantityByBanknoteEUR(Integer banknote);

	Eur getQuantityEur(Integer quantity);

	void updateQuantityByBanknoteEUR(Eur entity);

}
