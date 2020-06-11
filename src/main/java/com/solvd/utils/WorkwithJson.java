package com.solvd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.pojo.Transaction;
import com.solvd.services.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;

public class WorkwithJson {

<<<<<<< HEAD
    private static final Logger LOGGER = LogManager.getLogger(WorkwithJson.class);
    private Validation validation = new Validation();
=======
	private static final Logger LOGGER = LogManager.getLogger(WorkwithJson.class);
>>>>>>> 6a4d33e5bc27919f863c5d8c2b4c60593b274e36

	public Transaction JsonReader(String pathtoFile) {

<<<<<<< HEAD
        Transaction transaction = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            transaction = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Transaction.class);
            LOGGER.info("file already read");
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getStackTrace());
        } catch (IOException e) {
            validation.pathValidate();
        }
=======
		Transaction transaction = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			transaction = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Transaction.class);
			LOGGER.info("File is already read.");
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getStackTrace());
		} catch (IOException e) {
			LOGGER.error(e.getStackTrace());
		}
>>>>>>> 6a4d33e5bc27919f863c5d8c2b4c60593b274e36

		return transaction;
	}


}
