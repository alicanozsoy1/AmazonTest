package com.tchcareer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends ParentPage{

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div[1]")
    public static WebElement product;

    @FindBy(id = "add-to-cart-button")
    public static WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/h1")
    public static WebElement addedCart;

    @FindBy(id = "sp-cc-rejectall-link")
    public static WebElement cookieReject;

    @FindBy(xpath = "//*[@id=\"sw-gtc\"]/span/a")
    public static WebElement goToCart;

    @FindBy(id = "sc-subtotal-label-activecart")
    public static WebElement cart;

}
