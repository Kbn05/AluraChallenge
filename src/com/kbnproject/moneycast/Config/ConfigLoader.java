package com.kbnproject.moneycast.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;

    public ConfigLoader(String fileProperties) throws IOException {
        properties = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(fileProperties)){
            if(input == null){
                throw new IOException("Not found " + fileProperties);
            }
            properties.load(input);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
