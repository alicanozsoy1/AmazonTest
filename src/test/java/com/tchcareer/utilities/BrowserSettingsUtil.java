package com.tchcareer.utilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserSettingsUtil {
    public static ChromeOptions chromeSettings() {
        ChromeOptions option1 = new ChromeOptions();

        option1.addArguments(
                "--start-maximized",
                "--disable-notifications",
                "--remote-allow-origins=*"
        );

        option1.setExperimentalOption("excludeSwitches", new String[]{"disable-popup-blocking", "enable-automation"});

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        option1.setExperimentalOption("prefs", prefs);

        return option1;
    }

    public static EdgeOptions edgeSettings() {
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized");

        options.addArguments("--disable-notifications");

        options.addArguments("--remote-allow-origins=*");

        options.setCapability("ms:edgeOptions", "{\"excludeSwitches\": [\"disable-popup-blocking\", \"enable-automation\"]}");

        options.setCapability("ms:edgeOptions", "{\"prefs\": {\"credentials_enable_service\": false, \"profile.password_manager_enabled\": false}}");

        return options;
    }

    public static FirefoxOptions firefoxSettings() {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--start-maximized");

        options.addPreference("dom.webnotifications.enabled", false);

        options.addPreference("dom.push.enabled", false);

        options.addPreference("signon.rememberSignons", false);
        options.addPreference("browser.formfill.enable", false);
        options.addPreference("extensions.formautofill.addresses.enabled", false);
        options.addPreference("extensions.formautofill.creditCards.enabled", false);

        return options;
    }
}
