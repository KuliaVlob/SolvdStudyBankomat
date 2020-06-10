package com.solvd.menu;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Scanner;


public class MethodsMenu {
    private static final Logger LOGGER = LogManager.getLogger(MethodsMenu.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected String user;
    protected String path;
    protected WorkwithJson workwithJson = new WorkwithJson();
    private Double amount;
    private Users users;

//scheme.json
    public void withdrawFunds() {
        users.setLogin(user);
        Transaction transaction = workwithJson.JsonReader(path);
        amount = usersDAO.getUsersAmmount(user).getTotal_ammount();

        if (amount >= transaction.getAmount()) {

            amount -= transaction.getAmount();
            users.setTotal_ammount(amount);
            usersDAO.updateAmmount(users.getTotal_ammount(), users.getLogin());

        } else {
            LOGGER.info("The amount verification was not validated");
            System.out.println("Not enough money in your account");
            sumReValidation();
        }

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");

        displayBalance();

    }


    public void displayBalance() {
        Menu menu = new Menu();

        System.out.println("================================================================");
        System.out.println(usersDAO.getUsersAmmount(user));

        menu.reproduceSubmenu();

    }

    public Double converterToEuro() {

        Double coefficient = 1.133;
        amount = usersDAO.getUsersAmmount(user).getTotal_ammount();
        Double convert = amount * coefficient;
        LOGGER.info("The amount was converted into Euros");
        LOGGER.info(convert);
        return convert;

    }


    public void sumReValidation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================================");
        System.out.println("Do you want to try again? Enter Y/N");
        String ask = sc.next();

        switch (ask) {
            case ("y"):
            case ("Y"):
                break;
            default:
                exit();
        }

    }

    public void exit() {
        System.out.println("================================================================");
        System.out.println("Thank you for using application");
        LOGGER.info("Work completed!!!");
        System.out.println("================================================================");
        System.exit(0);
    }


    public void loginValidation() {
        Menu menu = new Menu();
        if (usersDAO.getUsersByLogin(user) != null) {
            LOGGER.info("The login check has been validated");
        } else {
            System.out.println("Уou entered an incorrect login");
            menu.getInputData();
        }
    }


}
