package com.solvd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.pojo.Transaction;
import com.solvd.validator.InfoRefuseValidation;
import com.solvd.validator.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class for parsing JSON files by established format
 * 
 * @author Ihor Hnidko
 */
public class WorkwithJson {

    private static final Logger LOGGER = LogManager.getLogger(WorkwithJson.class);
    private InputDataValidator pathValidator = new InputDataValidator();
    

    /**
     * Reading from JSON file
     * 
     * @param pathtoFile
     * @return object of {@link Transaction}, assigning values ​​to the fields from the file
     * @throws JsonProcessingException occurs while processing (parsing, generating) JSON content
     * @throws IOException if file does not exist
     * @see {@link InputDataValidator#pathValidate}
     */
	public Transaction JsonReader(String pathtoFile) {


        Transaction transaction = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            transaction = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Transaction.class);
            LOGGER.info("file already read");
        } catch (JsonProcessingException e) {
        	InfoRefuseValidation infoRefuseValidation = new InfoRefuseValidation();
            if (transaction == null) { 
        		System.out.println("JSON file is empty or file format is incorrect");
        		infoRefuseValidation.getValidationInfo();
        	}
          
        } catch (IOException e) {
            pathValidator.pathValidate();
        }

		return transaction;
	}


}
