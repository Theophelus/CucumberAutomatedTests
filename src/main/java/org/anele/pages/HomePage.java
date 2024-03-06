package org.anele.pages;

import org.anele.utils.BaseCore;

public class HomePage extends BaseCore {
    private String dashboardHeader = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";

    public String validateText() throws Exception {
        System.out.println("Home page Dashboard text: " + BaseCore.getText(dashboardHeader));
        return BaseCore.getText(dashboardHeader);

    }
}
