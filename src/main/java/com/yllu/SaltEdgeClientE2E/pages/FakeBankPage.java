package com.yllu.SaltEdgeClientE2E.pages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;


@Slf4j
@Getter
@Setter
public class FakeBankPage {


    private final static String PROCEED_BUTTON_CLASS = "btn-signup";
    private final static String CANCEL_BUTTON_CLASS = "btn-white";

    @FindBy(className = PROCEED_BUTTON_CLASS)
    public WebElement proceedElement;

    @FindBy(className = CANCEL_BUTTON_CLASS)
    public WebElement cancelElement;

    private WebDriver webDriver;

    public FakeBankPage() {
        webDriver = webDriver();
        PageFactory.initElements(webDriver, this);

    }

    public void navigateTo(String connectUrl) {
        webDriver.navigate().to(connectUrl);
    }

    public ConfirmPage clickProceed() {
        log.info("Clicking the Proceed button");
        run(() -> sleep(500))
                .andThen(() -> proceedElement.click());

        return new ConfirmPage(webDriver);
    }

    public void clickCancel() {
        log.info("Clicking the Proceed button");
        run(() -> sleep(500))
                .andThen(() -> cancelElement.click());
    }

    public WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

}
