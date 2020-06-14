package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.PropertyReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Convertor {

    private static final Logger LOGGER = LogManager.getLogger(Convertor.class);


    private Double convert;
    private String coefficientString = PropertyReader.getValueFromProperties("coefficient");
    private Double coefficient = Double.valueOf(coefficientString);

    public Double converterToUSD(Transaction transaction) {
        convert = transaction.getAmount()*coefficient;
        LOGGER.info("The amount was converted into Euros");
        LOGGER.info( transaction.getAmount()+ "------> "+convert);
        return convert;
    }

}
