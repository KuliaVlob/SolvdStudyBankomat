package com.solvd.dao;

import com.solvd.model.Usd;
import com.solvd.model.Users;

public interface IUsdDAO {
	
	    Usd getQuantityByBanknoteUSD(Integer banknote);
	    
	    void updateQuantityByBanknoteUSD(Usd entity);


}
