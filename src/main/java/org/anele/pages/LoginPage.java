package org.anele.pages;

import org.anele.model.User;
import org.anele.utils.BaseCore;
import org.anele.utils.JsonUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseCore {
    //define element locators
    private final By username = By.xpath("//input[@placeholder='Username']");
    private final By password = By.xpath("//input[@placeholder='Password']");
    private String loginBtn = "//button[@type='submit']";
//    private String dashboardHeader = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
    //define jsonReader Utils to get admin credentials
    protected User[] userData = JsonUtils.readUserCredentialsJson();
    public LoginPage(){}
    public void fillInLoginFormAsAdmin(){
        //filter json file and get values
        System.out.println("check json file: " +userData.length);
        for (User user : userData) {
            BaseCore.setValues(username, user.getUsername());
            BaseCore.setValues(password, user.getPassword());
        }
    }
    public void clickOnLoginBtn(){
        BaseCore.clickOnBtn(loginBtn);
    }
//    public String validateText() throws Exception {
//        System.out.println("Home page Dashboard text: " + BaseCore.getText(dashboardHeader));
//        return BaseCore.getText(dashboardHeader);
//
//    }
}
