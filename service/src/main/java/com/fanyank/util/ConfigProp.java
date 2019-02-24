package com.fanyank.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigProp {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigProp.class.getClassLoader().getResourceAsStream("conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigProp() {}

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
