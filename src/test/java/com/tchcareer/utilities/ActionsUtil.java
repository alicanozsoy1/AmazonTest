package com.tchcareer.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.tchcareer.driver.Driver.getDriver;
import static com.tchcareer.pages.MainPage.mainPageSignIn;
import static com.tchcareer.utilities.PageObjectUtil.actions;

public class ActionsUtil {

    public static void moveToElement(WebElement element) {
        actions.moveToElement(element).click(mainPageSignIn).perform();
    }

    public static void waitAndClick(WebElement webElement, int milliseconds) {
        actions.pause(milliseconds).click(webElement).perform();
    }

    public static void waitAndEnterText(WebElement element, int milliseconds, String text) {
        actions.pause(milliseconds).moveToElement(element).sendKeys(text).perform();
    }

    public ActionsUtil pause(int milliseconds) {
        actions.pause(milliseconds);
        return this;
    }

    public ActionsUtil click(WebElement element) {
        actions.click(element);
        return this;
    }

    public void perform() {
        actions.perform();
    }

}
