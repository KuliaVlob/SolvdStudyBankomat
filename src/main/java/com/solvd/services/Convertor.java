package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Convertor {

    private static final Logger LOGGER = LogManager.getLogger(ServicesATM.class);


    private Double coefficient = 1.133;
    private Double convert;

    public Double converterToUSD(Transaction transaction) {
        convert = transaction.getAmmount()*coefficient;
        LOGGER.info("The amount was converted into Euros");
        LOGGER.info( transaction.getAmmount()+ "------> "+convert);
        return convert;
    }

}
