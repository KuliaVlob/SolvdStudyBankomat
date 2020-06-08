package com.solvd;

import com.solvd.menu.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

        public static void main(String[] args) {

            Menu menu = new Menu();
            menu.getInputData();


//            WorkwithJson wj = new WorkwithJson();
//            Transaction transaction = wj.JsonReader("scheme.json");
//            System.out.println(transaction.getAmount()+ " " + transaction.getCurrency() + " " + transaction.getBanknote());

    }
}
