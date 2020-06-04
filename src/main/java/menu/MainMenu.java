package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.UsersDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainMenu {

    private final static Logger LOGGER = LogManager.getLogger(MainMenu.class);
    private Scanner sc = new Scanner(System.in);
    private String user;


    public void getInputData() {

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
                displayBalance();
                break;
            case ("W"):
                withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }

    public void withdrawFunds() {

        chooseNominal();
        //знімаємо кошти з балансу

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");
        displayBalance();

    }


    public void chooseNominal() {

        System.out.println("Enter the denomination of the banknotes: 5, 10, 20, 100, 200, 500");
        try {
            int nominal = sc.nextInt();
        } catch (InputMismatchException e) {
            LOGGER.error(e.getMessage());
        }


    }

    public void displayBalance() {

        UsersDAO usersDAO = new UsersDAO();
        usersDAO.getUsersByLogin(user);

        System.out.println("================================================================");
        usersDAO.getUsersAmount(user);
        System.out.println("================================================================");

        reproduceSubmenu();
    }


    public void reproduceSubmenu() {
        System.out.println("For withdraw funds enter:__________W");
        System.out.println("To change the source data, enter: _С");
        String action = sc.next();
        switch (action) {
            case ("W"):

                break;
            case ("C"):
                getInputData();
                break;
            default:
                break;
        }

        // sc.close();
    }
}