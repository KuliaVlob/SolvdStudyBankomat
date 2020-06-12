package com.solvd.services;

import com.solvd.dao.UsdDAO;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class BanknoteService {


    private Usd usd = new Usd();
    private UsdDAO usdDAO = new UsdDAO();
    WorkwithJson workwithJson = new WorkwithJson();
    ServicesATM servicesATM = new ServicesATM();
    private Transaction transaction =workwithJson.JsonReader(servicesATM.path + ".json");
    private double sumForGetingJSON = transaction.getAmmount();
    private Integer banknoteJSON = transaction.getBanknote();
    private double quantity;
    private String info = ("You get " + quantity + " By " + banknoteJSON + " banknotes");
    private static final Logger LOGGER = LogManager.getLogger(BanknoteService.class);


        public void getBanknoteUSD(Transaction transaction) {

        usd = usdDAO.getQuantityByBanknoteUSD(banknoteJSON);

        if (usd.getQuantity().equals("yes")) {
            convertToBancnote();
            if ((int) sumForGetingJSON > 0) {
                transaction.setBanknote((int) sumForGetingJSON);
                banknoteJSON = transaction.getBanknote();
                do {
                    if (usd.getQuantity().equals("yes")) {
                        convertToBancnote();
                    }
                } while (sumForGetingJSON != 0);
            } else {
                System.out.println(info);
            }
        } else {
            refuseInfo();
            List<Usd> banknote = usdDAO.getAvailableBanknote("yes");
            System.out.println(banknote);
            quitProgram();
        }

    }

    public void convertToBancnote() {
        quantity = sumForGetingJSON / banknoteJSON;
        quantity = (int) quantity;
        quantity *= banknoteJSON;
        sumForGetingJSON -= quantity;
        System.out.println(info);
    }

    public void refuseInfo() {
        System.out.println("Unfortunately, the ATM does not have the banknotes you need");
        System.out.println("The following banknotes are available at the ATM");
    }

    public void quitProgram() {
        LOGGER.error("To try again, log in again");
        System.exit(0);
    }

}
