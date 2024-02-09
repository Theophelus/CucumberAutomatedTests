package org.massimoDutti.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.an.E;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.massimoDutti.utils.Config;
import org.massimoDutti.utils.TakeScreenshot;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Hooks {
        public static WebDriver driver;
        @Before
        public void setup() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            EdgeOptions options = getChromeOptions(capabilities);
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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

    public EdgeOptions getChromeOptions(DesiredCapabilities capabilities) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("inprivate");
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        options.merge(capabilities);
        return options;
    }

}
