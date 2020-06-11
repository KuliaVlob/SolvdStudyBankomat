package com.solvd;

import com.solvd.dao.UsdDAO;
import com.solvd.menu.Menu;
import com.solvd.model.Usd;
import com.solvd.pojo.Transaction;
import com.solvd.utils.WorkwithJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

        public static void main(String[] args) {

//            Menu menu = new Menu();
//            menu.getInputData();


            WorkwithJson wj = new WorkwithJson();
            Transaction transaction = wj.JsonReader("scheme.json");
            System.out.println(transaction.getAmount() + " " + transaction.getCurrency() + " " + transaction.getBanknote());
            Double amount = Double.valueOf(transaction.getAmount());
            Integer banknote = transaction.getBanknote();
            Integer sum = 0;
            int quantity = 0;
            do {
                 sum += banknote;
                quantity++;
            } while (sum < amount);
            System.out.println(quantity);

        }
//    public void calculateBanknote() {
//
//        //валідація суми яка є в банкоматі чи більше рівне sumForGeting - можливо виводити це через select
//
//        String path = "scheme.json";
//        String user = "Dorosh";
//        Transaction transaction = workwithJson.JsonReader(path);
//        UsdDAO usdDAO = new UsdDAO();
//        if (new String(transaction.getCurrency()).equals("USD")) {
//            amount = usersDAO.getUsersAmmount(user).getTotal_ammount();
//            double sumForGeting = transaction.getAmount();
//            Integer banknote = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getBanknote();
//            double banknoteAmount = usdDAO.getQuantityByBanknoteUSD(transaction.getBanknote()).getQuantity();
//            System.out.println("Сума на рахкну " + amount + " сума яку треба зняти  " + sumForGeting +
//                    " номінал " + banknote + " сума банкнот " + " " + banknoteAmount);
//
//            if (sumForGeting <= banknoteAmount) {
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
