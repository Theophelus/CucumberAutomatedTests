package org.anele.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.anele.utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverFactory {
    protected static WebDriver driver;

    private DriverFactory() {
        driver = PageDriver.getWebDriver();
    }

    public static void getWebDriver(String browser) throws InterruptedException {
        if (driver == null) {
            initBrowser(browser);
        }
    }

    public static void initBrowser(String browser) throws InterruptedException {
//        define WebDriver instance
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        //run tests with desired capabilities
        if (Config.browserOptions) {
            options = getChromeOptions(capabilities);
        }
        if (browser.equalsIgnoreCase("chrome")) {
            //get configure browser values
            if (Config.browser.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                maximizeBrowser(driver);
            } else {
                if (Config.platform.equalsIgnoreCase("remote")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    maximizeBrowser(driver);
                }
            }
        }
//        else
//        if (browser.equalsIgnoreCase("edge")){
//
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        maximizeBrowser(driver);
//        }
        driver.get(Constant.BASE_URL);
        Thread.sleep(10000);
        PageDriver.setWebDriver(driver);
    }

    //set desired capabilities for chrome options
    static ChromeOptions getChromeOptions(DesiredCapabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        return options;
    }

    public static void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
