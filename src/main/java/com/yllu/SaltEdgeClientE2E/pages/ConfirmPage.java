package com.yllu.SaltEdgeClientE2E.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;

@Slf4j
public class ConfirmPage extends BasePage {

    private final static String CONFIRM_BUTTON_CLASS = "btn";

    @FindBy(className = CONFIRM_BUTTON_CLASS)
    public WebElement confirmElement;

    public ConfirmPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public FlowSelectionPage confirmClick() {
        log.info("Clicking the Proceed button");
        run(() -> sleep(500))
                .andThen(() -> confirmElement.click());

        return new FlowSelectionPage(webDriver);
    }
}
