package com.tw.extentreporting;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExtentManager {

    private static final ThreadLocal<ExtentTest> extentDriver = new ThreadLocal<>();

    /**
     * Returns the thread-safe {link com.aventstack.extentreports.ExtentTest}
     * instance fetched from ThreadLocal variable.
     * <p>
     * Sep 17, 2023
     *
     * @author Krishanu
     * @return Thread-safe {link com.aventstack.extentreports.ExtentTest} instance
     */
    static ExtentTest getExtentDriver() { // default access modifier: It can be accessed only within the package
        return extentDriver.get();
    }

    /**
     * Set the {link thread-safe {link com.aventstack.extentreports.ExtentTest}
     * instance to ThreadLocal variable.
     * <p>
     * Sep 17, 2023
     *
     * @author Krishanu
     * @param extentTest {link thread-safe {link com.aventstack.extentreports.ExtentTest}
     *             instance that needs to be saved from Thread safety issues
     */
    public static void setExtentDriver(ExtentTest extentTest) {

        if (Objects.nonNull(extentTest)) {
            extentDriver.set(extentTest);
        }

    }

    /**
     * Calling the remove() method on ThreadLocal variable ensures to set the
     * default value to ThreadLocal variable. It is much safer than assigning null
     * value to ThreadLocal variable.
     * <p>
     * Sep 17, 2023
     *
     * @author Krishanu
     */
    static void removeExtentDriver() {
        extentDriver.remove();
    }


}
