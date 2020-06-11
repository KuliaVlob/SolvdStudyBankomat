package com.solvd.services;

import com.solvd.dao.IUsdDAO;
import com.solvd.dao.UsersDAO;
import com.solvd.model.Users;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServicesATM {


    private static final Logger LOGGER = LogManager.getLogger(ServicesATM.class);
    private UsersDAO usersDAO = new UsersDAO();
    protected WorkwithJson workwithJson = new WorkwithJson();
    private Convertor convertor = new Convertor();
    protected Double amount;
    private Users users = null;
    protected String login;
    protected String path;
    private Validation validation = new Validation();
    private IUsdDAO usdDAO;

    public void withdrawFunds() {

        Transaction transaction = workwithJson.JsonReader(path + ".json");
        users = usersDAO.getUsersAmmount(login);
        amount = users.getTotal_ammount();
        switch (transaction.getCurrency()) {
            case ("USD"):
                if (amount >= transaction.getAmmount()) {
                    amount -= transaction.getAmmount();
                    usersDAO.updateAmmount(amount, users.getLogin());
                } else {
                    validation.sumReValidation();
                }
                reDisplayBalance();
                break;

            case ("EUR"):
                if (amount >= convertor.converterToUSD(transaction)) {
                    amount -= convertor.converterToUSD(transaction);
                    amount = new BigDecimal
                            (amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

                    usersDAO.updateAmmount(amount, users.getLogin());
                    reDisplayBalance();
                } else {
                    validation.sumReValidation();
                }
                reDisplayBalance();
                break;

            default:
                LOGGER.info("Unknown currency type. The session is closed.");
                System.exit(0);
                break;

        }
    }


    public void displayBalance() {
      DataATM dataATM =new DataATM();

        System.out.println("================================================================");
        System.out.println(usersDAO.getUsersAmmount(login));

        dataATM.reproduceSubmenu();

    }

    public void reDisplayBalance() {

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");

        displayBalance();

    }

//    public void getBanknote() {
//
//        //валідація суми яка є в банкоматі чи більше рівне sumForGeting - можливо виводити це через select
//
//        String path = "scheme.json";
//        String user = "Dorosh";
//        Transaction transaction = workwithJson.JsonReader(path);
//        if ((transaction.getCurrency()).equals("USD")) {
//            amount = usersDAO.getUsersAmmount(user).getTotal_ammount();
//            double sumForGeting = transaction.getAmmount();
//            Integer banknote = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getBanknote();
//            String banknoteAmount = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getQuantity();
//            System.out.println("Сума на рахкну " + amount + " сума яку треба зняти  " + sumForGeting +
//                    " номінал " + banknote + " сума банкнот " + " " + banknoteAmount);
//
//            double quantity = sumForGeting / banknote;
//            quantity*=banknote;
//            sumForGeting-=quantity;
//            if (sumForGeting <= amount) {
//                withdrawFunds(); // знімаємо гроші з рахунку
//                // тут має бути апдейт  banknoteAmount  в базі даних
//
//            } else {
//                System.out.println("банкоат видав суму " + banknoteAmount + "  по  " + banknote);
//                sumForGeting -= banknoteAmount;
//                // опдейт banknoteAmount  для banknote
//
//                //ділі можна витягнути максимальну суму яка є в банкнотах.. наприклад 500 = 50000 ..
//                //і повторити цей алгоритм.. і так до тих пір поки не знімемо всю суму
//
//
////кожен раз знімаючи купюри ми оновлюємо суми з двох таблиць
//
//            }
//
//
//        } else {  // тут реалізація для євро
//
//        }
//    }
}
