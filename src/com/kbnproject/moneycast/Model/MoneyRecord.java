package com.kbnproject.moneycast.Model;

import java.util.Map;

public record MoneyRecord(String baseCode, Map<String,Double> conversionRates) {

    public Double convertRate(String castValue) {
        return conversionRates.get(castValue);
    }
}
