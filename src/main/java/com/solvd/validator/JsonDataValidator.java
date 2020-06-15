package com.solvd.validator;

import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;


public class JsonDataValidator {
    private final static Logger LOGGER = LogManager.getLogger(JsonDataValidator.class);
    private InfoOfValidation infoOfValidation = new InfoOfValidation();

    public void sumReValidate() {
        LOGGER.error("The amount verification was not validated");
        System.out.println("Not enough money in your account");
        infoOfValidation.getValidationInfo();
    }

    public void jsonDataValidate(Transaction transaction) {

        if (transaction.getBanknote() > transaction.getAmount()) {
            LOGGER.error("Banknote more than amount, or amount is a negative value");
            System.out.println("Banknote more than the amount you want" +
                    " to withdraw from the account. Or you entered amount with a negative value");
            infoOfValidation.getValidationInfo();
        }
            else {
            Integer[] correctBanknote = {10, 20, 50, 100, 200, 500};
            boolean b = Arrays.asList(correctBanknote).contains(transaction.getBanknote());
                if(!b) {
                    LOGGER.error("Banknote is incorrect");
                    System.out.println("Input banknote is incorrect");
                    infoOfValidation.getValidationInfo();
                }
            }

            int minBanknote = 10;
            if (transaction.getAmount() % minBanknote != 0) {
                LOGGER.error("The amount not integer or not multiply of 10");
                System.out.println("To withdraw money from the account," +
                        " the amount must be an integer and a multiple of 10");
                infoOfValidation.getValidationInfo();
            }
    }

}
