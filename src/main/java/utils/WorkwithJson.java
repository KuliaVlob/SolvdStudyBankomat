package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class WorkwithJson {

    public Map JsonReader(String pathtoFile) {

        Map<?, ?> map = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            map = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Map.class);
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

}

