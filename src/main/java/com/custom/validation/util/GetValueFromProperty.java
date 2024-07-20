package com.custom.validation.util;

import java.util.Properties;

public class GetValueFromProperty {
    private static Properties properties;

    private GetValueFromProperty() {
    }

    public static String getValue(String key) {
        properties = new Properties();
        return properties.getProperty(key);
    }

    public static String getValue(String key, String defaultValue) {
        String value = properties.getProperty(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }
}
