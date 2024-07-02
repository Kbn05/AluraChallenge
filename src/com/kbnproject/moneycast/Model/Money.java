package com.kbnproject.moneycast.Model;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;

public class Money {

    private String base;

    private String rateConvert;

    public Double getRate() {
        return rate;
    }

    private Double rate;

    public Money(MoneyRecord data, String valueCast){
        this.base = data.baseCode();
        this.rateConvert = valueCast;
        this.rate = data.convertRate(valueCast);
    }

    @Override
    public String toString() {
        return "Base rate: " + base +
                ", Rate cast: " + rateConvert +
                ", Currency value: " + rate;
    }
}
