package com.tw.driver;

import com.tw.enums.RunMode;
import com.tw.utilities.ReadProperties;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() throws MalformedURLException {
        String runModeValue = ReadProperties.getValue("runmode").toUpperCase();
        AndroidDriver androidDriver = DriverFactory.getDr(RunMode.valueOf(runModeValue));
        DriverManager.setDriver(androidDriver);
    }

    public static void quitDriver() {
        try {
            if (Objects.nonNull(DriverManager.getDriver())) {
                DriverManager.getDriver().quit();
                DriverManager.removeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}