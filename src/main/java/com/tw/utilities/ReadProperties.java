package com.tw.utilities;

import com.tw.exceptions.PropertyFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadProperties {

    private ReadProperties() {
    }

    private static final Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();


    static {
        try (FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties")) {
            properties.load(file);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                CONFIGMAP.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static String getValue(String key) {

        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toLowerCase()))) {
            throw new PropertyFileException("Property with Key => " + key + " is not found!!! Please check the respective env.properties file...");
        }

        return CONFIGMAP.get(key.toLowerCase());
    }

}
