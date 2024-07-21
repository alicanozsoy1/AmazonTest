package com.tchcareer.utilities;

import com.tchcareer.pages.MainPage;
import com.tchcareer.pages.SearchPage;
import com.tchcareer.pages.SignInPage;
import com.tchcareer.pages.SignUpPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

import static com.tchcareer.driver.Driver.getDriver;

public class PageObjectUtil {
    public static WebDriverWait wait;
    public static MainPage mainPage;
    public static SignInPage signInPage;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static SignUpPage signUpPage;

    public static SearchPage searchPage;

    public static void initializeObjects() {
        mainPage = new MainPage();
        signInPage = new SignInPage();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        js = (JavascriptExecutor)getDriver();
        actions = new Actions(getDriver());
        signUpPage = new SignUpPage();
        searchPage = new SearchPage();

    }
}





