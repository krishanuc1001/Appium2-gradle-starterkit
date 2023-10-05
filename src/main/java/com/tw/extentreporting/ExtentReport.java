package com.tw.extentreporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tw.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReport {

    private static ExtentReports extentReports;

    public static void initExtentReport() {

        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.EXTENTREPORTFILEPATH);
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setReportName("Automation Report");
            extentSparkReporter.config().setDocumentTitle("Appium Extent Report");
            extentReports.attachReporter(extentSparkReporter);
        }

    }

    public static void createExtentTest(String testCaseName) {
        ExtentTest extentTest = extentReports.createTest(testCaseName);
        ExtentManager.setExtentDriver(extentTest);
    }

    public static void flushExtentReport() {

        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentManager.removeExtentDriver();
        }

    }

}
