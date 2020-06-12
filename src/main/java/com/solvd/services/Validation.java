package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Validation {
    private final static Logger LOGGER = LogManager.getLogger(Validation.class);
    private String incorrectData = "Input data are incorrect";
    private String instruction = "To try again, log in again";


    public void loginValidate(ServicesATM servicesATM) {

        DataATM dataATM = new DataATM();
        UsersDAO usersDAO = new UsersDAO();

        if (usersDAO.getUsersByLogin(servicesATM.login) != null) {
            LOGGER.info("The login check has been validated");
        } else {
            System.out.println("You entered an incorrect login");
            dataATM.getInputData();
        }
    }

    public void pathValidate() {
        LOGGER.error("You entered incorrect path");
        LOGGER.error(instruction);
        System.exit(0);
    }


    public void sumReValidate() {
        LOGGER.info("The amount verification was not validated");
        System.out.println("Not enough money in your account");
        getValidationInfo();
    }

    public void jsonDataValidate(Transaction transaction) {
        int minBanknote = 10;
        int[] correctbanknote = {10, 20, 50, 100, 200, 500};
        
        if (transaction.getBanknote() > transaction.getAmmount()) {

            getValidationInfo();
        }

        for (Integer banknotes : correctbanknote) {
            if (transaction.getBanknote().equals(banknotes)) {
                getValidationInfo();
            }
        }
        if (transaction.getAmmount()!=(int)(transaction.getAmmount()/minBanknote)){

            System.out.println(transaction.getAmmount()!=(int)(transaction.getAmmount()/minBanknote));
            getValidationInfo();
        }

    }

    public void getValidationInfo() {
        System.out.println("================================================================");
        LOGGER.info(incorrectData);
        LOGGER.error(instruction);
        System.exit(0);
    }


}
