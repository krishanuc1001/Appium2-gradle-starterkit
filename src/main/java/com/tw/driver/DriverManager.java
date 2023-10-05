package com.tw.driver;

import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {

    // Thread Local
    public static final ThreadLocal<AppiumDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(AppiumDriver driverRef) {
        if (Objects.nonNull(driverRef)) {
            dr.set(driverRef);
        }
    }

    public static void removeDriver() {
        dr.remove();
    }

}
