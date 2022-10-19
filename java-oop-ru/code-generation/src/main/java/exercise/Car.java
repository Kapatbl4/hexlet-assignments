package exercise;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        return objectMapper.writeValueAsString(this);
    }

    public static Car unserialize(String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        return objectMapper.readValue(data, Car.class);
    }
    // END
}
