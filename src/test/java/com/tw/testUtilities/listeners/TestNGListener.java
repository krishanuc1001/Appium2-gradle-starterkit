package com.tw.testUtilities.listeners;

import com.tw.extentreporting.ExtentLogger;
import com.tw.extentreporting.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestNGListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createExtentTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " => PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " => FAILED", true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " => SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
         * Not using this method now
         *
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * Not using this method now
         *
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * Not using this method now
         *
         */
    }


}
