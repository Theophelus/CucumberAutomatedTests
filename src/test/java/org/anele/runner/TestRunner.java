package org.anele.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.anele.hooks",
                "org.anele.stepDefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@PIM and @home and not @login and not @wip"
        )

public class TestRunner extends AbstractTestNGCucumberTests implements TestRunners {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenario(){
        return super.scenarios();
    }
}
