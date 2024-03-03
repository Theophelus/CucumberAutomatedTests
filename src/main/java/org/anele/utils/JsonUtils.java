package org.anele.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.anele.model.User;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
    Adding a json utils class to handle all json activities

 */

public class JsonUtils {

    public static User[] readUserCredentialsJson(){

        try (Reader reader = new FileReader("data/userCreds.json")){
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, User[].class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

