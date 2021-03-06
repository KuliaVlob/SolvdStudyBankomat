package com.solvd.validator;

import com.solvd.services.ServicesATM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class is designed to display information in case of failure
 * 
 * @author Yana Dorosh
 */
public class InfoRefuseValidation {

    private static final Logger LOGGER = LogManager.getLogger(InfoRefuseValidation.class);

    public void getValidationInfo() {
        System.out.println("================================================================");
        System.out.println("To try again, log in again");

        LOGGER.info("Exit the program");
        System.exit(0);
    }

}
