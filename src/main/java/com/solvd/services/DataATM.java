package com.solvd.services;

import com.solvd.pojo.Transaction;
import com.solvd.validator.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DataATM {

    private final static Logger LOGGER = LogManager.getLogger(DataATM.class);
    private Scanner sc = new Scanner(System.in);
    private ServicesATM servicesATM = new ServicesATM();
    private InputDataValidator loginValidator = new InputDataValidator();


    public void getInputData() {

        LOGGER.info("Login to the program");

        System.out.println("================================================================");
        System.out.print("Enter user: ");
        ServicesATM.login = sc.next();

        loginValidator.loginValidate(servicesATM);

        System.out.print("Enter path: ");
        servicesATM.path = sc.next();
        Transaction transaction = servicesATM.workwithJson.JsonReader(servicesATM.path + ".json");

        chooseAction();

    }


    public void chooseAction() {
        System.out.println("================================================================");
        System.out.println("To display balance press D");
        System.out.println("To Withdraw funds press W");

        String choosing = sc.next();
        choosing = choosing.toUpperCase();
        switch (choosing) {
            case ("D"):
                servicesATM.displayBalance();
                break;
            case ("W"):
                servicesATM.withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }


    public void reproduceSubmenu() {
        System.out.println("================================================================");
        System.out.println("To display balance press key D");
        System.out.println("To change the source data, enter press С");
        System.out.println("To exit press E");

        String action = sc.next();
        action = action.toUpperCase();
        switch (action) {
            case ("D"):
                servicesATM.displayBalance();
                break;
            case ("C"):
                getInputData();
                break;
            case ("E"):
                exit();
            default:
                reproduceSubmenu();
                break;
        }


    }

    public void displayNextInfo() {
    	
    
    	System.out.println("================================================================");
		System.out.println("Do you want to continue working with program? Y/N");
		System.out.println("Enter Y if yes.");
		System.out.println("Enter N if no.");

		String action = sc.next();
		action = action.toUpperCase();
		switch (action) {
		case ("Y"):

			System.out.println("You need to re-enter the input data to perform the operations");
			getInputData();
			break;

		default:
			exit();
			break;
		}

    }
    
    public void exit() {
        System.out.println("================================================================");
        System.out.println("Thank you for using application");
        LOGGER.info("Work completed!!!");
        System.out.println("================================================================");
        sc.close();
        System.exit(0);
    }


}
