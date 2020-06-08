package com.solvd.menu;

import com.solvd.dao.UsersDAO;

public class MethodsMenu {

    protected String user;
    protected String path;

    public void withdrawFunds() {

        //знімаємо кошти з балансу

        System.out.println("Funds have been deducted from your account.");
        System.out.println("Your account balance is:");
        displayBalance();

    }

    public void displayBalance() {

        Menu menu = new Menu();
        UsersDAO usersDAO = new UsersDAO();


        System.out.println("================================================================");
        System.out.println(usersDAO.getUsersAmmount(user));
        System.out.println("================================================================");

        menu.reproduceSubmenu();
    }

}
