package com.solvd.services;

import com.solvd.dao.EurDAO;
import com.solvd.model.Eur;
import com.solvd.utils.PropertyReader;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.dao.UsdDAO;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import com.solvd.validator.InfoRefuseValidation;

public class BanknoteService {


    private UsdDAO usdDAO = new UsdDAO();
    private EurDAO eurDAO = new EurDAO();
    private double sumForGettingJSON;
    private Integer banknoteJSON;
    private double quantity;
    private static final Logger LOGGER = LogManager.getLogger(BanknoteService.class);
    private InfoRefuseValidation infoOfValidation = new InfoRefuseValidation();
    private int minBanknote = Integer.parseInt(PropertyReader.getValueFromProperties("minBanknote"));

    public void getBanknoteUSD(Transaction transaction) {

        sumForGettingJSON = transaction.getAmount();
        banknoteJSON = transaction.getBanknote();

        try {
            Usd usd = usdDAO.getQuantityByBanknoteUSD(banknoteJSON);
            if (usd.getQuantity().equals("yes")) {
                convertToBanknote();
                System.out.println("You are getting: " + quantity + " USD. By: " + banknoteJSON + " banknotes");
                if (sumForGettingJSON > 0) {
                    transaction.setBanknote((int) sumForGettingJSON);
                    banknoteJSON = transaction.getBanknote();
                    for (Usd banknotes : usdDAO.getAvailableBanknoteUSD("yes")) {
                        if (banknotes.getBanknote().equals(banknoteJSON)) {
                            convertToBanknote();
                            System.out.println("You are getting: " + quantity + " USD. By: "
                                    + banknoteJSON + " banknotes");
                        }
                    }
                    if (sumForGettingJSON > minBanknote) {
                        convertToBanknote();
                        System.out.println("You are getting: " + quantity + " USD. By: " + minBanknote + " banknotes");
                    }
                }
            } else {
                getRefuseInfoUSD();
                infoOfValidation.getValidationInfo();
            }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            infoOfValidation.getValidationInfo();
        }

    }

    public void getBanknoteEUR(Transaction transaction) {
        sumForGettingJSON = transaction.getAmount();
        banknoteJSON = transaction.getBanknote();

        try {
            Eur eur = eurDAO.getQuantityByBanknoteEUR(banknoteJSON);
            if (eur.getQuantity().equals("yes")) {
                convertToBanknote();
                System.out.println("You are getting: " + quantity + " EUR. By: " + banknoteJSON + " banknotes");
                if (sumForGettingJSON > 0) {
                    transaction.setBanknote((int) sumForGettingJSON);
                    banknoteJSON = transaction.getBanknote();
                    for (Eur banknotes : eurDAO.getAvailableBanknoteEUR("yes")) {
                        if (banknotes.getBanknote().equals(banknoteJSON)) {
                            convertToBanknote();
                            System.out.println("You are getting: " + quantity + " EUR. By: "
                                    + banknoteJSON + " banknotes");
                        }
                    }
                    if (sumForGettingJSON > minBanknote) {
                        convertToBanknote();
                        System.out.println("You are getting: " + quantity + " EUR. By: " + banknoteJSON + " banknotes");
                    }
                }
            } else {
                getRefuseInfoEUR();
                infoOfValidation.getValidationInfo();
            }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            infoOfValidation.getValidationInfo();
        }
    }


    public void getAvailableBanknoteUSD() {
        try {
            System.out.println(usdDAO.getAvailableBanknoteUSD("yes"));
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            infoOfValidation.getValidationInfo();
        }

    }

    public void getAvailableBanknoteEUR() {
        try {
            System.out.println(eurDAO.getAvailableBanknoteEUR("yes"));
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

    public void getRefuseInfoUSD() {
        System.out.println("Unfortunately, the ATM does not have the banknotes you need");
        System.out.println("The following banknotes are available at the ATM");
        getAvailableBanknoteUSD();
    }

    public void getRefuseInfoEUR() {
        System.out.println("Unfortunately, the ATM does not have the banknotes you need");
        System.out.println("The following banknotes are available at the ATM");
        getAvailableBanknoteEUR();
    }
}
