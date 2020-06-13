package com.solvd;

import com.solvd.pojo.Transaction;
import com.solvd.services.DataATM;
import com.solvd.utils.WorkwithJson;

public class Executor {


    public static void main(String[] args) {

//        DataATM dataATM = new DataATM();
//        dataATM.getInputData();

        WorkwithJson wj = new WorkwithJson();
        String path = "a.json";
        Transaction transaction = wj.JsonReader(path);

        int[] correctbanknote = {10,20,50,100,200,500};
        for (Integer q : correctbanknote) {
            if (transaction.getBanknote().equals(q)) {
                System.out.println(q);
            }
        }
    }
}
