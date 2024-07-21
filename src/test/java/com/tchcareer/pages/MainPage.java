package com.tchcareer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage{

    @FindBy(id = "nav-link-accountList")
    public static WebElement mainPageAccount;

    @FindBy(xpath = "//span[@class=\"nav-action-inner\"]")
    public static WebElement mainPageSignIn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public static WebElement mainPageSignedIn;

    @FindBy(xpath = "//input[@placeholder=\"Ara Amazon.com.tr\"]")
    public static WebElement searchBar;
}
