package com.yllu.SaltEdgeClientE2E.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FakeBankPage {


    @FindBy(how = How.NAME, using = "Proceed")
    public WebElement proceedElement;

    //    private final ConfirmPage confirmPage;
    private final WebDriver webDriver;

    public FakeBankPage() {
        webDriver = webDriver();
    }

    public void navigateTo(String url) throws InterruptedException {
        webDriver.navigate().to(url);
    }

    public void clickProceed() {
        log.info("Clicking the Proceed button");
//        proceedElement.click();
    }

    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
