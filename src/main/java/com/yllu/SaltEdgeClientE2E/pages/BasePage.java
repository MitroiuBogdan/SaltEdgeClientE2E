package com.yllu.SaltEdgeClientE2E.pages;


import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public abstract class BasePage {

    protected final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }
}
