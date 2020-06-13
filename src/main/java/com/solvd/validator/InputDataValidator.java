package com.solvd.validator;

import com.solvd.dao.UsersDAO;
import com.solvd.services.DataATM;
import com.solvd.services.ServicesATM;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputDataValidator {

    private final static Logger LOGGER = LogManager.getLogger(InputDataValidator.class);
    private InfoOfValidation infoOfValidation = new InfoOfValidation();

    public void loginValidate(ServicesATM servicesATM) {

        DataATM dataATM = new DataATM();
        UsersDAO usersDAO = new UsersDAO();
        try {
        if (usersDAO.getUsersByLogin(servicesATM.login) != null) {
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
        System.out.println(infoOfValidation.instruction);
        System.exit(0);
    }

}
