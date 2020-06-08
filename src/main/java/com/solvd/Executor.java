package com.solvd;

import com.solvd.menu.MainMenu;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

        public static void main(String[] args) {

            MainMenu mainMenu = new MainMenu();
            mainMenu.getInputData();


//            WorkwithJson wj = new WorkwithJson();
//            Transaction transaction = wj.JsonReader("scheme.json");
//            System.out.println(transaction.getAmount()+ " " + transaction.getCurrency() + " " + transaction.getBanknote());

    }
}
