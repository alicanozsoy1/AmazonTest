package com.tchcareer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends ParentPage{

    @FindBy(id = "ap_email")
    public static WebElement emailBox;

    @FindBy(id = "continue")
    public static WebElement continueButton;

    @FindBy(id = "ap_password")
    public static WebElement passwordBox;

    @FindBy(id = "signInSubmit")
    public static WebElement signUpPageSignUpButton;

    @FindBy(xpath = "//*[@id=\"auth-email-invalid-claim-alert\"]/div/div")
    public static WebElement MailErrorMsg;

    @FindBy(css = "#auth-email-missing-alert > div > div")
    public static WebElement mailMissingAlert;

    @FindBy(id = "auth-error-message-box")
    public static WebElement invalidMailErrorBox;

    @FindBy(id = "auth-error-message-box")
    public static WebElement passwordAlert;

    @FindBy(xpath = "//*[@id=\"auth-password-missing-alert\"]/div/div")
    public static WebElement passwordErrorMsg;

}
