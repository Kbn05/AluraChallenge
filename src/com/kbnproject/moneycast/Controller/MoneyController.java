package com.kbnproject.moneycast.Controller;

import com.kbnproject.moneycast.Model.ConversionRecord;
import com.kbnproject.moneycast.Model.Money;
import com.kbnproject.moneycast.Model.MoneyRecord;
import com.kbnproject.moneycast.Repository.CurrencyRepository;
import com.kbnproject.moneycast.Service.GsonService;
import com.kbnproject.moneycast.Service.HttpService;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class MoneyController {

    HttpService httpService;

    GsonService gsonService = new GsonService();

    Money money;

    CurrencyRepository currencyRepository = new CurrencyRepository();

    public MoneyController(String apiKey) {
        this.httpService = new HttpService(apiKey);
    }

    public String getMoneyCast(String moneyCast) {
        try {
            return httpService.httpReq(moneyCast);
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

//    public String doFilter(String jsonData, String rateFilter){
//        try{
//            return gsonService.filterJson(jsonData, rateFilter);
//        }catch (Exception e){
//            return e.getMessage();
//        }
//    }

    public Money castRate(String dataJson, String valueCast){
        try{
            MoneyRecord dataRecord = gsonService.toObject(dataJson);
            money = new Money(dataRecord, valueCast);
            return money;
        }catch (IllegalArgumentException e){
            System.out.println("Argument Exception");
            return null;
        }
    }

    public Double valueCasted(Double value) {
        Double valCast = money.getRate();
        double v = valCast * value;
        currencyRepository.setCurrencyList(new ConversionRecord(money, v));
        return v;
    }

    public List<ConversionRecord> getList() {
        return currencyRepository.getCurrencyList();
    }
}
