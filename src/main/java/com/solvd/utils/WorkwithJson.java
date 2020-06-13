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

    private static final Logger LOGGER = LogManager.getLogger(WorkwithJson.class);
    private Validation validation = new Validation();


	public Transaction JsonReader(String pathtoFile) {


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

		return transaction;
	}


}
