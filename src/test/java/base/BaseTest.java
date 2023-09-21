package base;

import com.tw.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Driver.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.quitDriver();
    }

}
