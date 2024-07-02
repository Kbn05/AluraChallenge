package com.kbnproject.moneycast.Service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kbnproject.moneycast.Model.MoneyRecord;

public class GsonService {

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    public MoneyRecord toObject(String data){
        return gson.fromJson(data, MoneyRecord.class);
    }

    public String toJson(MoneyRecord data){
        return gson.toJson(data);
    }
}
