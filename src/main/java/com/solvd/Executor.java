package com.solvd;

import com.solvd.menu.MainMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

        public static void main(String[] args) {

            MainMenu mainMenu = new MainMenu();
            mainMenu.getInputData();

    }
}