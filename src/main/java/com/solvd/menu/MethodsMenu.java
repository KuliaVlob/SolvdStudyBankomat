package com.solvd.menu;

import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class MethodsMenu {
    private static final Logger LOGGER = LogManager.getLogger(MethodsMenu.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected String user;
    protected String path;
    private WorkwithJson workwithJson = new WorkwithJson();
    private Double amount;
    Users users = new Users();

    public void withdrawFunds() {


        Transaction transaction = workwithJson.JsonReader(path + ".json");

        LOGGER.info("Get data from file: " + transaction.getAmount() +
                transaction.getCurrency() + " Banknote : " + transaction.getBanknote());
        amount = usersDAO.getUsersAmmount(user).getTotal_ammount();
        //  LOGGER.info(usersDAO.getUsersByLogin(user));
        switch (transaction.getCurrency()) {
        
        case ("USD"):
        	

        // LOGGER.info(amount);

        if (amount >= transaction.getAmount()) {
            amount -= transaction.getAmount();

            //  LOGGER.info("Р РµР·СѓР»СЊС‚Р°С‚ РІС–РґРЅС–РјР°РЅРЅСЏ" + amount);

            users.setTotal_ammount(amount);
            users.setLogin(user);

            //   LOGGER.info("РџРµСЂРµРІС–СЂС‡РєР° С‡Рё РїСЂРѕСЃРµС‚Р°Р»РѕСЃСЊ" + users.getTotal_ammount() + " " + users.getLogin());

            usersDAO.updateAmmount(users.getTotal_ammount(), users.getLogin());

            //LOGGER.info("Check updated" + usersDAO.getUsersByLogin(user));
          //scheme.json
        } else {
            LOGGER.info("The amount verification was not validated");
            System.out.println("Not enough money in your account");
            sumReValidation();
        }

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");

        displayBalance();

                break;
        
        case ("EUR"):
        
        	 
//        	 converted to eur ammount from db
        	 amount = converterToEuro(amount);
        	 
        	 if (amount >= transaction.getAmount()) {
                 amount -= transaction.getAmount();
//                 System.out.println("minus: " + amount);
                 
//                 new summ in eur convert to usd
                 amount = converterToUsd(amount);
                 
// rounding usd summ to 2 signs after comma; convert to bigDecimal and back to Double
                 amount = new BigDecimal
                 		(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
//                 System.out.println("New double: " + amount);
                 //  LOGGER.info("Р РµР·СѓР»СЊС‚Р°С‚ РІС–РґРЅС–РјР°РЅРЅСЏ" + amount);

                 users.setTotal_ammount(amount);
                 users.setLogin(user);

                 //   LOGGER.info("РџРµСЂРµРІС–СЂС‡РєР° С‡Рё РїСЂРѕСЃРµС‚Р°Р»РѕСЃСЊ" + users.getTotal_ammount() + " " + users.getLogin());

                 usersDAO.updateAmmount(users.getTotal_ammount(), users.getLogin());

                 //LOGGER.info("Check updated" + usersDAO.getUsersByLogin(user));
               //scheme.json
             } else {
                  
                 sumReValidation();
             }

             System.out.println("Funds have been deducted from your account.");
             System.out.println("Your account balance is:");

             displayBalance();
        	
        	LOGGER.info("Still working on this part");
        System.exit(0);

            break;
            
        default:
        	LOGGER.info("Unknown currency type. The session is closed.");
        	System.exit(0);
            break;
       
        }
    }


   

	public void displayBalance() {
        Menu menu = new Menu();

        System.out.println("================================================================");
        System.out.println(usersDAO.getUsersAmmount(user));
        System.out.println("================================================================");

        menu.reproduceSubmenu();

    }

    public Double converterToEuro(Double amount) {

        Double coefficient = 1.133;
        Double convert = amount * coefficient;

        LOGGER.info("The amount was converted into Euros");
        LOGGER.info(convert);
        return convert;

    }

    public Double converterToUsd(Double amount) {

        Double coefficient = 1.133;
        Double convert = amount / coefficient;

        LOGGER.info("The amount was converted into Usd");
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
            System.out.println("РЈou entered an incorrect login");
            menu.getInputData();
        }
    }


}