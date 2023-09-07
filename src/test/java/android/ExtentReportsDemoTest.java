package android;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class ExtentReportsDemoTest {

    @Test
    public void extentReportTest() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReports/index.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Automation Report");
        extentSparkReporter.config().setDocumentTitle("Appium Extent Report");
        extentReports.attachReporter(extentSparkReporter);

        ExtentTest extentTest = extentReports.createTest("First Appium Test")
                .assignAuthor("Krish")
                .assignCategory("Smoke")
                .assignDevice("Windows");
        extentTest.pass("<<============== Test passed ==============>>");
        extentTest.fail("<<============== Test failed ==============>>");
        extentTest.info("<<============== Sample Test ==============>>");

        extentReports.flush();
    }
}
