package com.tchcareer.hooks;

import com.tchcareer.utilities.MailSlurpUtil;
import com.tchcareer.utilities.PageObjectUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.tchcareer.driver.Driver.closeDriver;


public class Hooks {

    @Before
    public void beforeScenario() {
        PageObjectUtil.initializeObjects();
    }

    @Before(value = "@MailSlurp")
    public void before_QA(Scenario scenario) throws Exception {
        MailSlurpUtil.initializeObjects();
    }

    @After
    public void afterScenario(Scenario scenario) {
         closeDriver();
    }

}
