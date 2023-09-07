package com.tw.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class DriverManager {

    private DriverManager() {}

    // Thread Local
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        if (Objects.nonNull(driverRef)) {
            dr.set(driverRef);
        }
    }

    public static void removeDriver() {
        dr.remove();
    }


}
