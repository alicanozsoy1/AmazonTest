package com.tchcareer.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@Test
@CucumberOptions
        (
                plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                features = "src/test/resources/features/",
                glue = {"com/tchcareer/stepDefinitions","com/tchcareer/hooks"},
                tags ="@AddToCart",
                dryRun = false,
                publish = true,
                monochrome = false,
                snippets = CAMELCASE
        )
public class TestNG_CucumberRunner extends AbstractTestNGCucumberTests {
}