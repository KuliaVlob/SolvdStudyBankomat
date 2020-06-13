package com.solvd.validator;

import com.solvd.services.ServicesATM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoOfValidation {

    private static final Logger LOGGER = LogManager.getLogger(InfoOfValidation.class);
    protected String instruction = "To try again, log in again";

    public void getValidationInfo() {
        System.out.println("================================================================");
        System.out.println(instruction);

        LOGGER.info("Exit the program");
        System.exit(0);
    }

}
