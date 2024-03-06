package org.anele.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.anele.base.Config;
import org.anele.base.DriverFactory;
import org.anele.base.PageDriver;
import org.anele.utils.TestContext;


public class Hooks {
//    private TestContext testContext;
    @Before
    public void setup() throws InterruptedException {
        String browser = Config.browser;
        DriverFactory.getWebDriver(browser);
//        testContext = new TestContext();
        //set drivers
        System.out.println("Drivers to be set: " + PageDriver.getWebDriver());
        System.out.println("Driver instantiated" + PageDriver.getWebDriver().getTitle());
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
