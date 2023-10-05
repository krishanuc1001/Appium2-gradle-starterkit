package com.tw.driver;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.Map;

public class SauceLabsDriver implements IDriver {
    @Override
    public AppiumDriver getDriver() throws MalformedURLException {
        return null;
    }

    @Override
    public AppiumDriver getDriver(Map<String, String> map) throws MalformedURLException {
        /**
         * Add code to initialize driver wrt Saucelabs
         */
        return null;
    }

    @Override
    public AppiumDriver getDriver(String browser, Map<String, String> map) throws MalformedURLException {
        return null;
    }
}
