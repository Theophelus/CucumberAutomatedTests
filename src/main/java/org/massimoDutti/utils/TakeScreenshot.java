package org.massimoDutti.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenshot {
    private final WebDriver driver;
    public TakeScreenshot(WebDriver driver){
        this.driver = driver;
    }



    public void captureScreenshot(Scenario scenario){
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshotsByte = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotsByte, "image/png", "image");
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
