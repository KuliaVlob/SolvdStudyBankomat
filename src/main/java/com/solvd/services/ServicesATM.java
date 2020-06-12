package com.solvd.services;

import com.solvd.dao.IUsdDAO;
import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServicesATM {


    private static final Logger LOGGER = LogManager.getLogger(ServicesATM.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected WorkwithJson workwithJson = new WorkwithJson();
    private Convertor convertor = new Convertor();
    protected Double amount;
    private Users users = null;
    protected String login;
    protected String path;
    private Validation validation = new Validation();
    private BanknoteService banknoteService = new BanknoteService();


    public void withdrawFunds() {
        DataATM dataATM = new DataATM();
        Transaction transaction = workwithJson.JsonReader(path + ".json");

        validation.jsonDataValidation(transaction);
        users = usersDAO.getUsersAmmount(login);
        amount = users.getTotal_ammount();
        switch (transaction.getCurrency()) {
            case ("USD"):

                if (amount >= transaction.getAmmount()) {
                    amount -= transaction.getAmmount();

                    banknoteService.getBanknoteUSD(transaction);

                    usersDAO.updateAmmount(amount, users.getLogin());
                } else {
                    validation.sumReValidation();
                }
                dataATM.reproduceSubmenu();
                break;

            case ("EUR"):
                if (amount >= convertor.converterToUSD(transaction)) {
                    amount -= convertor.converterToUSD(transaction);
                    amount = new BigDecimal
                            (amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

                    usersDAO.updateAmmount(amount, users.getLogin());
                    dataATM.reproduceSubmenu();
                } else {
                    validation.sumReValidation();
                }
                dataATM.reproduceSubmenu();
                break;

            default:
                LOGGER.info("Unknown currency type. The session is closed.");
                System.exit(0);
                break;

        }
    }


    public void displayBalance() {
        DataATM dataATM = new DataATM();

        System.out.println("================================================================");
        System.out.println("Your account balance is:");
        System.out.println(usersDAO.getUsersAmmount(login));

        System.out.println("You need to re-enter the input data to perform the operations");
        dataATM.getInputData();


    }

//    public void reDisplayBalance() {
//
//        System.out.println("Funds have been deducted from your account.");
//        System.out.println("Your account balance is:");
//
//        displayBalance();
//
//    }

}
