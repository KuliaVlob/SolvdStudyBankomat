package com.solvd.services;

import com.solvd.dao.UsdDAO;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class BanknoteService {


    private Usd usd = new Usd();
    private UsdDAO usdDAO = new UsdDAO();
    private double sumForGetingJSON;
    private Integer banknoteJSON;
    private double quantity;
    private static final Logger LOGGER = LogManager.getLogger(BanknoteService.class);


    public void getBanknoteUSD(Transaction transaction) {

        sumForGetingJSON = transaction.getAmmount();
        banknoteJSON = transaction.getBanknote();
        usd = usdDAO.getQuantityByBanknoteUSD(banknoteJSON);

        if (usd.getQuantity().equals("yes")) {
            convertToBanknote();
            if ((int) sumForGetingJSON > 0) {
                transaction.setBanknote((int) sumForGetingJSON);
                banknoteJSON = transaction.getBanknote();
                getAvailableBanknote();
                do {
                    if (usd.getQuantity().equals("yes")) {
                        convertToBanknote();
                    } else {
                        System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");
                    }
                } while (sumForGetingJSON != 0);
            } else {
                System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");
            }
        } else {
            getRefuseInfo();
            getAvailableBanknote();
            quitProgram();
        }

    }

    public void getAvailableBanknote() {
        List<Usd> banknote = usdDAO.getAvailableBanknote("yes");
        System.out.println(banknote);
    }


    public void convertToBanknote() {
        quantity = sumForGetingJSON / banknoteJSON;
        quantity = (int) quantity;
        quantity *= banknoteJSON;
        sumForGetingJSON -= quantity;
        System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");
    }

    public void getRefuseInfo() {
        System.out.println("Unfortunately, the ATM does not have the banknotes you need");
        System.out.println("The following banknotes are available at the ATM");
    }

    public void quitProgram() {
        LOGGER.error("To try again, log in again");
        System.exit(0);
    }

}
