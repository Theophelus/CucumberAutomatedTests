package org.massimoDutti.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.massimoDutti.utils.TakeScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Hooks {
        public static WebDriver driver;
        TakeScreenshot takeScreenshot;

        @Before
        public void setup() {
            if (driver == null) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                //disable the sandbox mode for Edge
                options.setCapability("ms:edgeOptions", "--no-sandbox");
                driver = new EdgeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            }
        }
        @AfterStep
        public void takeScreenshot(Scenario scenario){

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            final byte[] screenshotsByte = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotsByte, "image/png", "image");

        }
        @After
        public void tearDown(Scenario scenario) {

            if (driver != null) {
                driver.quit();
                driver = null; // Resetting the driver to null after quitting
            }

        }
}
