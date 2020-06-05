package menu;

import java.util.Scanner;

import dao.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMenu {

    private final static Logger LOGGER = LogManager.getLogger(MainMenu.class);
    private Scanner sc = new Scanner(System.in);
    private String user;


    public void getInputData() {
        LOGGER.info("Login to the program");
        System.out.print("Enter user: ");
        user = sc.next();

        System.out.print("Enter path: ");
        String path = sc.next();

        chooseAction();

    }

    public void chooseAction() {

        System.out.println("Display balance: D");
        System.out.println("Withdraw funds:  W");

        String choosing = sc.next();
        switch (choosing) {
            case ("D"):
            case ("d"):
                displayBalance();
                break;
            case ("W"):
            case ("w"):
                withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }

    public void withdrawFunds() {

        //знімаємо кошти з балансу

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");
        displayBalance();

    }

    public void displayBalance() {

        UsersDAO usersDAO = new UsersDAO();


        System.out.println("================================================================");
        System.out.println(usersDAO.getUsersAmount(user));
        System.out.println("================================================================");

        reproduceSubmenu();
    }

    public void reproduceSubmenu() {

        System.out.println("For withdraw funds enter:__________W");
        System.out.println("To change the source data, enter: _С");
        System.out.println("Exit<------------------------------E");

        String action = sc.next();

        switch (action) {
            case ("W"):
            case ("w"):

                break;
            case ("C"):
            case ("c"):

                getInputData();

                break;
            case ("E"):
            case ("e"):
                System.out.println("Thank you for using application");
                LOGGER.info("Work completed!!!");
                sc.close();
                System.exit(0);
            default:
                reproduceSubmenu();
                break;
        }


    }

}