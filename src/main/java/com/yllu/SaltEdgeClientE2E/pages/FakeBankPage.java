package com.yllu.SaltEdgeClientE2E.pages;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;

@Component
@Slf4j
public class FakeBankPage {


    private final static String PROCEED_BUTTON_CLASS = "btn-signup";

    @FindBy(className = PROCEED_BUTTON_CLASS)
    public WebElement proceedElement;

    //    private final ConfirmPage confirmPage;
    private final WebDriver webDriver;

    public FakeBankPage() {
        webDriver = webDriver();
        PageFactory.initElements(webDriver, this);

    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }


    public void clickProceed() {
        log.info("Clicking the Proceed button");
        run(() -> sleep(500))
                .andThen(() -> proceedElement.click());
    }

    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
