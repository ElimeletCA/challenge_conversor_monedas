package com.elimeletca;

public class Exchange {
    private final Source _source;
    public Exchange(Source source){
        _source = source;
    }
    public String getConvertValues(String fromcurrency, String tocurrency, Double value){
        double result;
        if (fromcurrency == "USD") {
            result = value * _source.GetExchangeRate().conversion_rates().get(tocurrency);
        } else {
            result = value / _source.GetExchangeRate().conversion_rates().get(fromcurrency);
        }
        return "El valor de " + value + fromcurrency+" es de: " + String.format("%.2f", result)+tocurrency;
    }

}
