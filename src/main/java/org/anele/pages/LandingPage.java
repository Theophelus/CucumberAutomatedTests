package org.anele.pages;

import org.anele.base.PageDriver;
import org.anele.utils.ReusableMethods;
import org.anele.utils.GetWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.anele.locators.LandingPageElements.*;
import static org.anele.utils.ReusableMethods.*;
import static org.anele.utils.GetWebElements.*;

public class LandingPage {
    //define a constructor with Webdriver parameters
//    WebDriver driver;
    public LandingPage() {
        //define drivers
//        driver = PageDriver.getCurrentDriver();
    }
    public void clickSelectLocationBtn() {
        clickOnBtn(selectLocation);
    }
    //define a method to select a region, country and a language on the sidebar
    public void selectLocation(String region, String country, String language) throws InterruptedException {

        List<WebElement> locations = GetWebElements.getWebElementsByXpath(filterLocationList);
        if (!locations.isEmpty()){

            for(WebElement selectLocationFromList: locations){
                if (selectLocationFromList.getText().equals(region)){
                   //click filtered region
                    selectLocationFromList.click();
                    //wait for the first index from the list of countries be available
                    customWaitForAListOfElements(getWebElementsByXpath(filterCountryList), 10);
                    //filter by Countries
                    filterList(getWebElementsByXpath(filterCountryList), country);
                    //wait for the first index from the list of languages be available
                    customWaitForAListOfElements(getWebElementsByXpath(filterLanguageList), 4);
                    //filter by Languages and select spoken language
                    filterList(getWebElementsByXpath(filterLanguageList), language);
                    // break out of selectLocationFromList loop
                    break;
                }
            }
        }else
            throw new NoSuchElementException("elements not found");

    }
    //Validate Select location value if it changes
    public String validateLocation() throws Exception {
       return getText(selectedLocation);
    }
    //click On Gender buttons
    public void clicksOnLoginButton(String element) throws InterruptedException {
        clickBtn(element);
    }

    public void acceptCookies() throws InterruptedException {
        handleConfigureCookies();
    }

    public Boolean validateLink(){

        return checkPartialLink(manPartialLink);
    }
}
