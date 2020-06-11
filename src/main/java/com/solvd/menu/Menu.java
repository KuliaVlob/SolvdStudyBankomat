package com.solvd.menu;

import java.util.Scanner;


import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

<<<<<<< HEAD
    private final static Logger LOGGER = LogManager.getLogger(Menu.class);
    private Scanner sc = new Scanner(System.in);
    private MethodsMenu methods = new MethodsMenu();


    public void getInputData() {

        LOGGER.info("Login to the program");

        System.out.println("================================================================");

        System.out.print("Enter user: ");
        methods.user = sc.next();

        methods.loginValidation();

        System.out.print("Enter path: ");
        methods.path = sc.next();
        Transaction transaction = methods.workwithJson.JsonReader(methods.path + ".json");
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
                methods.displayBalance();
                break;
            case ("W"):
            case ("w"):
                methods.withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }


    public void reproduceSubmenu() {
        System.out.println("================================================================");
        System.out.println("For withdraw funds enter:__________W");
        System.out.println("To change the source data, enter: _С");
        System.out.println("Exit<------------------------------E");

        String action = sc.next();

        switch (action) {
            case ("W"):
            case ("w"):
                methods.withdrawFunds();
                break;
            case ("C"):
            case ("c"):
                getInputData();
                break;
            case ("E"):
            case ("e"):
                sc.close();
                methods.exit();
            default:
                reproduceSubmenu();
                break;
        }


    }
=======
	private final static Logger LOGGER = LogManager.getLogger(Menu.class);
	private Scanner sc = new Scanner(System.in);
	private MethodsMenu methods = new MethodsMenu();

	public void getInputData() {

		LOGGER.info("Login to the program");

		System.out.println("================================================================");

		System.out.print("Enter user: ");
		methods.user = sc.next();

		methods.loginValidation();

		System.out.print("Enter path: ");
		methods.path = sc.next();

		chooseAction();

	}

	public void chooseAction() {
		System.out.println("================================================================");
		System.out.println("Display balance: D");
		System.out.println("Withdraw funds:  W");

		String choosing = sc.next();
		System.out.println("================================================================");
		switch (choosing) {
		case ("D"):
		case ("d"):
			methods.displayBalance();
			break;
		case ("W"):
		case ("w"):
			methods.withdrawFunds();
			break;
		default:
			chooseAction();
			break;
		}
	}

	public void reproduceSubmenu() {
		System.out.println("================================================================");
		System.out.println("For withdraw funds enter:__________W");
		System.out.println("To change the source data, enter: _С");
		System.out.println("Exit<------------------------------E");

		String action = sc.next();
		System.out.println("================================================================");
		switch (action) {
		case ("W"):
		case ("w"):

			methods.withdrawFunds();
			
			break;
		case ("C"):
		case ("c"):

			getInputData();

			break;
		case ("E"):
		case ("e"):
			
			sc.close();
		
			methods.exit();
			
		default:
			
			reproduceSubmenu();
			
			break;
		}

	}
>>>>>>> 6a4d33e5bc27919f863c5d8c2b4c60593b274e36

}