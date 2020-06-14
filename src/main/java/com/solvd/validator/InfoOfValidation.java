package com.solvd.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoOfValidation {

    private static final Logger LOGGER = LogManager.getLogger(InfoOfValidation.class);

    public void getValidationInfo() {
        System.out.println("================================================================");
        System.out.println("To try again, log in again");

        LOGGER.info("Exit the program");
        System.exit(0);
    }

}
