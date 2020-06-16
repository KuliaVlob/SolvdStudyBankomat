package com.solvd.validator;

import com.solvd.dao.UsersDAO;
import com.solvd.pojo.Transaction;
import com.solvd.services.DataATM;
import com.solvd.services.ServicesATM;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Yana Dorosh
 */
public class InputDataValidator {

    private final static Logger LOGGER = LogManager.getLogger(InputDataValidator.class);
    private InfoRefuseValidation infoRefuseValidation = new InfoRefuseValidation();

    /**
     * Login data validation for compliance with the login in the database
     * 
     * @param servicesATM is object with variable {@link ServicesATM#login}, an input data
     * @throws PersistenceException occurs when there is a problem with connection to database
     */
    public void loginValidate(ServicesATM servicesATM) {

        DataATM dataATM = new DataATM();
        UsersDAO usersDAO = new UsersDAO();
        try {
        if (usersDAO.getUsersByLogin(ServicesATM.login) != null) {
            LOGGER.info("The login check has been validated");
        } else {
            LOGGER.error("Login is incorrect");
            System.out.println("You entered an incorrect login");
            dataATM.getInputData();
        }
        } catch (PersistenceException e) {
            LOGGER.error("Sorry, too many connections, please, try again later.");
            dataATM.exit();
        }
    }

   
    
    public void pathValidate() {
        LOGGER.error("Path is incorrect");
        System.out.println("You entered incorrect path");
        infoRefuseValidation.getValidationInfo();
    }

}
