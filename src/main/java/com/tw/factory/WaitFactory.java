package com.tw.factory;

import com.tw.constants.FrameworkConstants;
import com.tw.driver.DriverManager;
import com.tw.exceptions.FrameworkException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Slf4j
public class WaitFactory {

    static WebElement element;
    static List<WebElement> elementList;
    private static final String MESSAGE = "Element cannot be interacted, please check...";

    public static void performFluentWait(By by) {
        waitForPageToLoad();
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver());
        wait.pollingEvery(Duration.ofSeconds(FrameworkConstants.getFLUENTWAITPOLLINGTIME()));
        wait.withTimeout(Duration.ofSeconds(FrameworkConstants.getFLUENTWAITTIME()));
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);

        try {
            element = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
        } catch (Exception exception) {
            log.error(MESSAGE, exception);
            throw new FrameworkException(MESSAGE, exception);
        }
    }

    public static void waitForPageToLoad() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String readyState = js.executeScript("return document.readyState").toString();
        while (!readyState.equalsIgnoreCase("complete")) {
            readyState = js.executeScript("return document.readyState").toString();
        }
    }

    public static void performFluentWaitOnElements(By by) {
        if (Objects.nonNull(elementList)) {
            elementList.clear();
        }
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .pollingEvery(Duration.ofSeconds(FrameworkConstants.getFLUENTWAITPOLLINGTIME()))
                .withTimeout(Duration.ofSeconds(FrameworkConstants.getFLUENTWAITTIME()))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);

        try {
            elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception exception) {
            log.error(MESSAGE, exception);
            throw new FrameworkException(MESSAGE, exception);
        }
    }

    public void explicitWait(By by) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5))
                .withMessage(MESSAGE)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(DriverManager.getDriver().findElement(by)));
    }

}
