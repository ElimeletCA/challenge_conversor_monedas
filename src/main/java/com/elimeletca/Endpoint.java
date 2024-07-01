package com.elimeletca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;

public class Endpoint {

    public String getEndpoint (){
        Gson gson = new GsonBuilder().create();
        Credentials credentials = null;
        try (
            FileReader reader = new FileReader("secrets.json")) {
            credentials = gson.fromJson(reader, Credentials.class);
            String key = credentials.getApiKey();
            String endpoint = "https://v6.exchangerate-api.com/v6/"+key+"/latest/USD";
            return endpoint;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
