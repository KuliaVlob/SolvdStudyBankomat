package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class MainMenu {

    private final static Logger LOGGER = Logger.getLogger(MainMenu.class);
    private Scanner sc = new Scanner(System.in);


    public void getInputData() {
        //  try {
        System.out.print("Enter user: ");
        String user = sc.next();

//                if (user!= getUser ) {                        //перевірка з user бази
//                throw new UsersException();
//            } catch (NumberFormatException | UsersException e) {
//                e.printStackTrace();
//                LOGGER.error(e.getMessage());
//            }
//        }

        System.out.print("Enter path: ");             /// перевірка наяності файлу
        String path = sc.next();

        chooseAction();


    }

    public void chooseAction() {

        System.out.println("Display balance: D");
        System.out.println("Withdraw funds:  W");

        String choosing = sc.next();
        switch (choosing) {
            case ("D"):

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
// відображаємо баланс
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