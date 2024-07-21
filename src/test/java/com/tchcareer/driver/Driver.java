package com.tchcareer.driver;

import com.tchcareer.utilities.BrowserSettingsUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.tchcareer.utilities.BrowserSettingsUtil.edgeSettings;
import static com.tchcareer.utilities.BrowserSettingsUtil.firefoxSettings;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser)

    {
        if (driver == null) {

            browser = browser == null ? "chrome" : browser;

            switch (browser) {
                case "chrome":
                    driver = WebDriverManager.chromedriver().avoidShutdownHook().capabilities(BrowserSettingsUtil.chromeSettings()).create();
                    break;

                case "firefox":
                    driver = WebDriverManager.firefoxdriver().avoidShutdownHook().capabilities(firefoxSettings()).create();
                    break;

                case "edge":
                    driver = new EdgeDriver(edgeSettings());
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driver = new ChromeDriver(options);
                    break;
            }
        }

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            getDriver("chrome");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
