package com.solvd.services;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import com.solvd.validator.InfoRefuseValidation;
import com.solvd.validator.JsonDataValidator;
import org.apache.ibatis.exceptions.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class represents main options of a program
 * 
 * @author Yana Dorosh
 */
public class ServicesATM {

    private static final Logger LOGGER = LogManager.getLogger(ServicesATM.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected WorkwithJson workwithJson = new WorkwithJson();
    private Convertor convertor = new Convertor();
    public static String login;
    protected String path;
    private JsonDataValidator validation = new JsonDataValidator();
    private BanknoteService banknoteService = new BanknoteService();
    private InfoRefuseValidation infoRefuseValidation = new InfoRefuseValidation();

    /**
     * Withdrawing the amount from the account, 
     * work with {@link Usd} and {@link Eur}. Subtraction and 
     * updating {@link Users}.total_amount if validators did not work
     * @throws PersistenceException occurs when 
     * there is a problem with connection to database 
     * @see BigDecimal
     * @see RoundingMode
     * 
     */
    public void withdrawFunds() {

        DataATM dataATM = new DataATM();
        Transaction transaction = workwithJson.JsonReader(path + ".json");

        try {
            Users users = usersDAO.getUsersAmount(login);
            Double amount = users.getTotal_amount();
            validation.jsonDataValidate(transaction);
            LOGGER.info("Banknote is correct");
            switch (transaction.getCurrency()) {
                case ("USD"):
                    if (amount >= transaction.getAmount()) {
                        amount -= transaction.getAmount();
                        banknoteService.getBanknoteUSD(transaction);
                        usersDAO.updateAmount(amount, users.getLogin());
                        LOGGER.info(+transaction.getAmount() + " - the amount has been deducted from your account ");
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
                        banknoteService.getBanknoteEUR(transaction);
                        convertor.getInfoConvert(transaction);
                        usersDAO.updateAmount(amount, users.getLogin());
                        LOGGER.info(+convertor.convert + " - the amount has been deducted from your account ");
                        dataATM.reproduceSubmenu();
                    } else {
                        validation.sumReValidate();
                    }
                    dataATM.reproduceSubmenu();
                    break;

                default:
                    LOGGER.info("Unknown currency type. The session is closed.");
                    infoRefuseValidation.getValidationInfo();
                    break;

            }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            dataATM.exit();
        }
    }

    /**
     * Displays {@link Users}.total_amount from database
     * @throws PersistenceException occurs when 
     * there is a problem with connection to database 
     */
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
