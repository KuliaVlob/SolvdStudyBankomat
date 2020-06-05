package com.solvd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.pojo.Transaction;

import java.io.IOException;
import java.nio.file.Paths;


public class WorkwithJson {

    public Transaction JsonReader(String pathtoFile) {

        Transaction transaction = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            transaction = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Transaction.class);
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transaction;
    }

}

