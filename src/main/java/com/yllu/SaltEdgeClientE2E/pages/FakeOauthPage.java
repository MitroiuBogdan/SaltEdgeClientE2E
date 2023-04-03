package com.yllu.SaltEdgeClientE2E.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FakeOauthPage extends BasePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;
    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;


    public void ClickProceed() {
    }

    public void ClickCancel() {
    }


    @Override
    public void navigate(String url) {
        navigateTo(url);
    }
}
