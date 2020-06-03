package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class WorkwithJson {

    public Object JsonReader( String pathtoFile) {

        Object object = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = Object.class.getResourceAsStream(pathtoFile);
            object = mapper.readValue(is, Object.class);
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

}

