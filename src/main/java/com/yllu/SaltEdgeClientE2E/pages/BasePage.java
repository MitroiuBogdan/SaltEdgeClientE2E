package com.yllu.SaltEdgeClientE2E.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;


public abstract class BasePage {

    private WebDriver webDriver;

    public BasePage() {
        webDriver = webDriver();
    }

    @PostConstruct
    public void InitPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

    public abstract void navigate();


    public WebDriver webDriver() {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
