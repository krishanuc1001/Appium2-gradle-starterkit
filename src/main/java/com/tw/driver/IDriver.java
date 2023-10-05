package com.tw.driver;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.Map;

public interface IDriver {

    AppiumDriver getDriver() throws MalformedURLException;

    AppiumDriver getDriver(Map<String, String> map) throws MalformedURLException;

    AppiumDriver getDriver(String browser, Map<String, String> map) throws MalformedURLException;
}
