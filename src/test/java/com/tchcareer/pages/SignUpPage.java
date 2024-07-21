package com.tchcareer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends ParentPage{

    @FindBy(id = "createAccountSubmit")
    public static WebElement mainPageSignUp;

    @FindBy(id = "ap_customer_name")
    public static WebElement nameBox;

    @FindBy(id = "ap_email")
    public static WebElement emailBox;

    @FindBy(id = "ap_password")
    public static WebElement passwordBox;

    @FindBy(id = "ap_password_check")
    public static WebElement passwordCheckBox;

    @FindBy(id = "continue")
    public static WebElement createAccount;

}
