package org.massimoDutti.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.massimoDutti.stepDefinitions",
                "org.massimoDutti.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@login"
        )

public class TestRunner extends AbstractTestNGCucumberTests implements TestRunners {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenario(){
        return super.scenarios();
    }
}
