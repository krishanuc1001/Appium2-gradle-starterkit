package com.tw.driver;

import com.tw.enums.RunMode;
import com.tw.factory.DriverFactory;
import com.tw.utilities.ReadProperties;
import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {

    public static void initDriver() {

        try {
            if (Objects.isNull(DriverManager.getDriver())) {
                String runModeValue = ReadProperties.getValue("runmode").toUpperCase();
                AppiumDriver driver = DriverFactory.getDr(RunMode.valueOf(runModeValue));
                DriverManager.setDriver(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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