package com.solvd.services;

import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DataATM {

    private final static Logger LOGGER = LogManager.getLogger(DataATM.class);
    private Scanner sc = new Scanner(System.in);
    ServicesATM servicesATM = new ServicesATM();
    Validation validation = new Validation();



    public void getInputData() {

        LOGGER.info("Login to the program");

        System.out.println("================================================================");
        System.out.print("Enter user: ");
        servicesATM.login = sc.next();

        validation.loginValidation(servicesATM);

        System.out.print("Enter path: ");
        servicesATM.path = sc.next();
        Transaction transaction = servicesATM.workwithJson.JsonReader(servicesATM.path + ".json");

        chooseAction();

    }


    public void chooseAction() {
        System.out.println("================================================================");
        System.out.println("Display balance: D");
        System.out.println("Withdraw funds:  W");

        String choosing = sc.next();

        switch (choosing) {
            case ("D"):
            case ("d"):
                servicesATM.displayBalance();
                break;
            case ("W"):
            case ("w"):
                servicesATM.withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }


    public void reproduceSubmenu() {
        System.out.println("================================================================");
        System.out.println("To change the source data, enter: _С");
        System.out.println("Exit<------------------------------E");

        String action = sc.next();

        switch (action) {
            case ("C"):
            case ("c"):
                getInputData();
                break;
            case ("E"):
            case ("e"):
                sc.close();
                exit();
            default:
                reproduceSubmenu();
                break;
        }


    }

    public void exit() {
        System.out.println("================================================================");
        System.out.println("Thank you for using application");
        LOGGER.info("Work completed!!!");
        System.out.println("================================================================");
        System.exit(0);
    }


}
