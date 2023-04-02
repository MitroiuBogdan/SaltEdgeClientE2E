package com.yllu.SaltEdgeClientE2E.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage implements BasePageTemplate{

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;
    public void ClickLogin() {
        System.out.println("HomePage - ClickLogin");
        lnkLogin.click();
    }

    @Override
    public void navigate() {

    }
}
