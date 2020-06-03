package menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class MainMenu {


    private Scanner sc = new Scanner(System.in);


    private final static Logger LOGGER = Logger.getLogger(MainMenu.class);

    public void getInputData() {
        //  try {
        System.out.println("Enter user:           ");
        String user = sc.next();

//                if (user!= getUser ) {                        //перевірка з user бази
//                throw new UsersException();
//            } catch (NumberFormatException | UsersException e) {
//                e.printStackTrace();
//                LOGGER.error(e.getMessage());
//            }
//        }

        System.out.println("Enter path to file: ");             /// перевірка наяності файлу
        String path = sc.next();


    }

    public void chooseAction() {

        System.out.println("Display balance: D");
        System.out.println("Withdraw funds:  W");

        String choosing = sc.next();
        switch (choosing) {
            case ("D"):

                break;
            case ("W"):

                break;

            default:
                chooseAction();
                break;
        }

        sc.close();
    }
}