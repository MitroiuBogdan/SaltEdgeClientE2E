package com.yllu.SaltEdgeClientE2E.pages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;


@Slf4j
@Getter
@Setter
public class FakeBankPage extends BasePage {


    private final static String PROCEED_BUTTON_CLASS = "btn-signup";
    private final static String CANCEL_BUTTON_CLASS = "btn-white";

    @FindBy(className = PROCEED_BUTTON_CLASS)
    public WebElement proceedElement;

    @FindBy(className = CANCEL_BUTTON_CLASS)
    public WebElement cancelElement;


    public FakeBankPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public ConfirmPage clickProceed() {
        log.info("Clicking the Proceed button");
        run(() -> sleep(500));
        proceedElement.click();
        return new ConfirmPage(webDriver);
    }

    public void clickCancel() {
        log.info("Clicking the Cancel button");
        run(() -> sleep(500)).andThen(() -> cancelElement.click());
    }
}
