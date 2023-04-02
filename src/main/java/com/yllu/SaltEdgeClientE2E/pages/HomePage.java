package com.yllu.SaltEdgeClientE2E.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage implements BasePageTemplate {

    private final LoginPage loginPage;
    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    @FindBy(how = How.LINK_TEXT, using = "Employee Details")
    public WebElement lnkEmployeeDetails;

    public HomePage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void ClickLogin() {
        System.out.println("HomePage - ClickLogin");
        lnkLogin.click();
    }

    @Override
    public void navigate() {

    }

    public boolean existEmployeeDetails() {
        return lnkEmployeeDetails.isDisplayed();
    }

}
