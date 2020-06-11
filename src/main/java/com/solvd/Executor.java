package com.solvd;

import com.solvd.dao.UsdDAO;
import com.solvd.menu.Menu;
import com.solvd.menu.MethodsMenu;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import com.solvd.services.DataATM;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) {

        DataATM dataATM = new DataATM();
        dataATM.getInputData();


//            Menu menu = new Menu();
//            menu.getInputData();


//            WorkwithJson wj = new WorkwithJson();
//            Transaction transaction = wj.JsonReader("a.json");
//            System.out.println(transaction.getAmount() + " " + transaction.getCurrency() + " " + transaction.getBanknote());
//            Integer amount = transaction.getAmount();


//            
//            WorkwithJson wj = new WorkwithJson();
//            Transaction transaction = wj.JsonReader("scheme.json");
//            System.out.println(transaction.getAmmount() + " " + transaction.getCurrency() + " " + transaction.getBanknote());
//            Integer amount = transaction.getAmmount();

//            Integer banknote = transaction.getBanknote();
//            Integer sum = 0;
//            int quantity = 0;
//            do {
//                 sum += banknote;
//                quantity++;
//            } while (sum < amount);
//            System.out.println(quantity);
    }

}
