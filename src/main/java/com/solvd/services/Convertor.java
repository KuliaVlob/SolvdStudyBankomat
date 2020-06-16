package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.PropertyReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for converting {@link Usd} to {@link Eur}
 * 
 * @author Yana Dorosh
 * @author Iryna Iemelianova
 */
public class Convertor {

    private static final Logger LOGGER = LogManager.getLogger(Convertor.class);


    protected Double convert;
    private String coefficientString = PropertyReader.getValueFromProperties("coefficient");
    private Double coefficient = Double.valueOf(coefficientString);

    /**
     * Convert EUR from JSON file into {@link Usd}
     * 
     * @param coefficient - {@link Double} value from properties
     * @param transaction - object of a {@link Transaction}
     * @return convert - converting value in {@link Usd}
     * @see {@link Transaction#getAmount}
     */
    public Double converterToUSD(Transaction transaction) {
        convert = transaction.getAmount()*coefficient;

        return convert;
    }

    /**
     * Displays info about converting value in {@link Usd}
     */
    public void getInfoConvert(Transaction transaction){
        LOGGER.info("The amount was converted into USD");
        LOGGER.info( transaction.getAmount()+ "------> "+convert);
    }

}
