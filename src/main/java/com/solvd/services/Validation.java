package com.solvd.services;

        import com.solvd.dao.UsersDAO;
        import com.solvd.pojo.Transaction;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;


public class Validation {
    private final static Logger LOGGER = LogManager.getLogger(Validation.class);
    private String instruction = "To try again, log in again";
    private int minBanknote = 10;

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
        System.out.println(instruction);
        System.exit(0);
    }


    public void sumReValidate() {
        LOGGER.error("The amount verification was not validated");
        System.out.println("Not enough money in your account");
        getValidationInfo();
    }

    public void jsonDataValidate(Transaction transaction) {

        int[] correctBanknote = {10, 20, 50, 100, 200, 500};

        if (transaction.getBanknote() > transaction.getAmmount()) {
            LOGGER.error("Banknote more than amount");
            System.out.println("Banknote more than the amount you want" +
                    " to withdraw from the account");
            getValidationInfo();
        }

        for (Integer banknotes : correctBanknote) {
            if (!transaction.getBanknote().equals(transaction.getBanknote())) {
                LOGGER.error("Banknote is incorrect");
                getValidationInfo();
            }
        }

        if (transaction.getAmmount() % minBanknote != 0) {
            LOGGER.error("The amount not integer or not multiply of 10");
            System.out.println("To withdraw money from the account," +
                    " the amount must be an integer and a multiple of 10");
            getValidationInfo();
        }

    }

    public void getValidationInfo() {
        System.out.println("================================================================");
        System.out.println(instruction);
        System.exit(0);
    }


}
