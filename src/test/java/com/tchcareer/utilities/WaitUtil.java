package com.tchcareer.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import static com.tchcareer.driver.Driver.getDriver;

public class WaitUtil
{
    public static void waitFor(int second)
    {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return e;
    }

    public static <T> WebElement waitForClickablility(T element_YA_DA_locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        WebElement element=null;
        if (element_YA_DA_locator instanceof WebElement)
            element= wait.until(ExpectedConditions.elementToBeClickable((WebElement) element_YA_DA_locator));

        if (element_YA_DA_locator instanceof By)
            element= wait.until(ExpectedConditions.elementToBeClickable((By) element_YA_DA_locator));

        return element;
    }

    public static void waitForPageToLoad(long timeout)
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        }
        catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static WebElement fluentWait(final WebElement webElement, int timeout)
    {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(Duration.ofMillis(timeout))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class)
                .withMessage("Fluent wait kullaniyorum");

        return (WebElement) wait.until(driver -> { return webElement;});
    }


}

