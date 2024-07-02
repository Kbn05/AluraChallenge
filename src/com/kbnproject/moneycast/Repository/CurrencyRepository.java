package com.kbnproject.moneycast.Repository;

import com.kbnproject.moneycast.Model.ConversionRecord;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {

    List<ConversionRecord> currencyList = new ArrayList<>();

    public void setCurrencyList(ConversionRecord conversionRecord) {
        currencyList.add(conversionRecord);
    }

    public List<ConversionRecord> getCurrencyList() {
        return currencyList;
    }
}
