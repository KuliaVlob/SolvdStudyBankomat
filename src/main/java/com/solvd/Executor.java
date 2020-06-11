package com.solvd;

import com.solvd.dao.IUsersDAO;
import com.solvd.dao.UsdDAO;
import com.solvd.menu.Menu;
import com.solvd.menu.MethodsMenu;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import com.solvd.services.DataATM;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);
    private static IUsersDAO usersDAO;

    public static void main(String[] args) {

//        DataATM dataATM = new DataATM();
//        dataATM.getInputData();


//            Menu menu = new Menu();
//            menu.getInputData();


//            WorkwithJson wj = new WorkwithJson();
//            Transaction transaction = wj.JsonReader("a.json");
//            System.out.println(transaction.getAmount() + " " + transaction.getCurrency() + " " + transaction.getBanknote());
//            Integer amount = transaction.getAmount();

//        Usd usd = new Usd();
//        String user = "Dorosh";
//        UsdDAO usdDAO = new UsdDAO();
//        WorkwithJson wj = new WorkwithJson();
//        Transaction transaction = wj.JsonReader("a.json");
//        System.out.println(transaction.getAmmount() + " " + transaction.getCurrency() + " " + transaction.getBanknote());
//        List<Usd> usds = usdDAO.getUSD();
//        System.out.println(usds);
//        if ((transaction.getCurrency()).equals("USD")) {
////            Double amount = usersDAO.getUsersAmmount(user).getTotal_ammount();
//            double sumForGeting = transaction.getAmmount();
//            Integer banknote = transaction.getBanknote();
////            Integer banknote1 = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getBanknote();
//            String banknoteAmount = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getQuantity();
////            System.out.println("Сума на рахкну " + ammount + " сума яку треба зняти  " + sumForGeting +
////                    " номінал " + banknote + " сума банкнот " + " " + banknoteAmount);
//
//            for (Usd entity : usds) {
//                String quantity = entity.getQuantity();
//                Integer banknotedb = entity.getBanknote();
//                System.out.println(quantity);
//
//                if (quantity.equals("yes")) {
//                    double quantity1 = sumForGeting / banknote; //555/50
//                    quantity1 *= banknote;
//                    sumForGeting -= quantity1;
//                    System.out.println("зняли " + quantity1);
//                    if(sumForGeting%quantity1 != 0 &&  banknotedb<= banknote) {
//
//                    }
//                }
//            }


//            Integer sum = 0;
//            int quantity = 0;
//            do {
//                 sum += banknote;
//                quantity++;
//            } while (sum < amount);
//            System.out.println(quantity);
//        }
    }
}

