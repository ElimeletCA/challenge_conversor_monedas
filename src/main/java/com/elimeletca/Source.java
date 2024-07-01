package com.elimeletca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class Source {
    private ExchangeRateApiClient exchangeRateApiClient = new ExchangeRateApiClient();
    private String json = exchangeRateApiClient.getExchangeRate();

    public ExchangeRate GetExchangeRate(){
        Gson gson = new GsonBuilder().create();
        ExchangeRate exchangeRate = null;
        exchangeRate = gson.fromJson(json, ExchangeRate.class);
        return exchangeRate;
    }
}
