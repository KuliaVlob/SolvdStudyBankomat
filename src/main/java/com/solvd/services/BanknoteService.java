package com.solvd.services;

import com.solvd.dao.UsdDAO;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;

import com.solvd.validator.InfoOfValidation;
import javafx.print.Collation;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BanknoteService {


    private Usd usd = new Usd();
    private UsdDAO usdDAO = new UsdDAO();
    private double sumForGettingJSON;
    private Integer banknoteJSON;
    private double quantity;
    private static final Logger LOGGER = LogManager.getLogger(BanknoteService.class);
    private InfoOfValidation infoOfValidation = new InfoOfValidation();

    public void getBanknoteUSD(Transaction transaction) {

        sumForGettingJSON = transaction.getAmount();
        banknoteJSON = transaction.getBanknote();

        try {
            usd = usdDAO.getQuantityByBanknoteUSD(banknoteJSON);
            System.out.println(usdDAO.getAvailableBanknoteUSD("yes"));
            if (usd.getQuantity().equals("yes")) {//перевіряю чи є в наявності банкнота якщо є то ->
                convertToBanknote(); //знімаю суму кратну купюрі
                System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");// виводжу на екран повідомлення зняття першої суми
                if ((int) sumForGettingJSON > 0) { // перевіряю чи залишок знятої суми більше 0 якщо так то ->
                    transaction.setBanknote((int) sumForGettingJSON); // присвоюю залишок вхідним данним з джисона
                    banknoteJSON = transaction.getBanknote();// переоприділяю змінну.. тепер вона дорівнює залишку
                    for (Usd banknotes : usdDAO.getAvailableBanknoteUSD("yes")) {
                        if (banknotes.getBanknote().equals(banknoteJSON)) { // перевіряю чи залишок дорівнює банкноті ка є в наявності
                            convertToBanknote();// знімаю залишок з рахунку
                            System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");// виводжу на екран повідомлення про зняття залишку
                        }
                    }

                    for (Usd banknotes : usdDAO.getAvailableBanknoteUSD("yes")) {
                        if(banknotes.getBanknote().compareTo((banknoteJSON));
                        System.out.println(usdDAO.getAvailableBanknoteUSD("yes"));
                        System.out.println(banknoteJSON);


                   }
                    System.out.println("є не знятий залишок");
                } else {
                    System.out.println("You are getting: " + quantity + " By: " + banknoteJSON + " banknotes");// виводиться якщо одразу зняло всю суму
                }
            } else {
                getRefuseInfo();
                infoOfValidation.getValidationInfo();
            }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            infoOfValidation.getValidationInfo();
        }

    }


    public void getAvailableBanknote() {
        try {
            System.out.println(usdDAO.getAvailableBanknoteUSD("yes"));

        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            infoOfValidation.getValidationInfo();
        }

    }


    public void convertToBanknote() {
        quantity = sumForGettingJSON / banknoteJSON;
        quantity = (int) quantity;
        quantity *= banknoteJSON;
        sumForGettingJSON -= quantity;

    }

    public void getRefuseInfo() {
        System.out.println("Unfortunately, the ATM does not have the banknotes you need");
        System.out.println("The following banknotes are available at the ATM");
        getAvailableBanknote();
    }

}
