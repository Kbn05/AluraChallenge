package com.kbnproject.moneycast.Model;

import java.time.LocalDateTime;

public class ConversionRecord {
    private Money money;
    private Double value;
    private LocalDateTime date;

    public ConversionRecord(Money money, Double value){
        this.money = money;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" + money +
                ", Conversion value:" + value +
                ", Conversion time:" + date +
                "}" + "\n";
    }
}
