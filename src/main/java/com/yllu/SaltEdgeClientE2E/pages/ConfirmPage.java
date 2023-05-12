package com.yllu.SaltEdgeClientE2E.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class ConfirmPage extends BasePage {


    @FindBy(how = How.NAME, using = "Confirm")
    public WebElement confirmElement;

    @Override
    public void navigate() {

    }
}
