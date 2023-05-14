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
public class FlowSelectionPage extends BasePage {


    private final static String CLASS_GRANT_ACCESS = "btn-primary";
    private final static String LINK_TEXT_GRANT_ACCESS = "Grant access";
    @FindBy(xpath = "//a[contains(@class, '" + CLASS_GRANT_ACCESS + "') and contains(., '" + LINK_TEXT_GRANT_ACCESS + "')]")
    public WebElement grantAccessElement;


    public FlowSelectionPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickGrantAccess() {
        log.info("Clicking the Grant access button");
        run(() -> sleep(500));
        grantAccessElement.click();
    }

}
