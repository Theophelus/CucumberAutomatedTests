package org.massimoDutti.locators;

public interface LandingPageElements {
    public String selectLocation = "/html[1]/body[1]/app-root[1]/worldwide-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/worldwide-search-button[1]/button[1]";
    public String selectedLocation = "//div[@class=\"btn-world-center\"]";
    public String filterLocationList = "//div[@class=\"list-button list-icons has-ico-post\"]";
    public String filterCountryList = "//div[@class=\"list-button list-secundary list-icons has-ico-post\"]";
    public String filterLanguageList = "//div[@class=\"list-button list-tertiary list-icons has-ico-pre\"]";
    public String acceptCookies = "//button[@id=\"onetrust-accept-btn-handler\"]";
    public String configureCoookies = "//button[@id=\"onetrust-pc-btn-handler\"]";
    public String confirmConfiguredCookies = "//*[@id=\"onetrust-pc-sdk\"]/div[3]/div[1]/button";
    public String manPartialLink = "https://www.massimodutti.com/ww/men-n1343";
    public String defaultMarketPopup = "//*[@id=\"BannerGeoblock\"]/div/div/div/div";
    public String clickNoText = "//div[contains(text(), \"No\")]";
    public String clickYesText = "//div[contains(text(), \"Yes\")]";
}
