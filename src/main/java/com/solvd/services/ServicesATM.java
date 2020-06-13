package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;

import com.solvd.validator.JsonDataValidator;
import org.apache.ibatis.exceptions.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServicesATM {

    private static final Logger LOGGER = LogManager.getLogger(ServicesATM.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected WorkwithJson workwithJson = new WorkwithJson();
    private Convertor convertor = new Convertor();
    public static String login;
    protected String path;
    private JsonDataValidator validation = new JsonDataValidator();
    private BanknoteService banknoteService = new BanknoteService();


    public void withdrawFunds() {

        DataATM dataATM = new DataATM();
        Transaction transaction = workwithJson.JsonReader(path + ".json");

        try {
            Users users = usersDAO.getUsersAmount(login);
            Double amount = users.getTotal_amount();
            validation.jsonDataValidate(transaction);

            switch (transaction.getCurrency()) {
                case ("USD"):

                    if (amount >= transaction.getAmount()) {
                        amount -= transaction.getAmount();

                        banknoteService.getBanknoteUSD(transaction);

                        usersDAO.updateAmount(amount, users.getLogin());

                        dataATM.reproduceSubmenu();
                    } else {
                        validation.sumReValidate();
                    }
                    dataATM.reproduceSubmenu();
                    break;

                case ("EUR"):
                    if (amount >= convertor.converterToUSD(transaction)) {
                        amount -= convertor.converterToUSD(transaction);
                        amount = new BigDecimal
                                (amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

                        usersDAO.updateAmount(amount, users.getLogin());

                    } else {
                        validation.sumReValidate();
                    }
                    dataATM.reproduceSubmenu();
                    break;

                default:
                    LOGGER.info("Unknown currency type. The session is closed.");
                    System.exit(0);
                    break;

            }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            dataATM.exit();
        }
    }


    public void displayBalance() {
        DataATM dataATM = new DataATM();

        System.out.println("================================================================");
        System.out.println("Your account balance is:");
        try {
            System.out.println(usersDAO.getUsersAmount(login));
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            dataATM.exit();
        }
        
        dataATM.displayNextInfo();

    }


}
