package com.yllu.SaltEdgeClientE2E.pages_saltedge;

import com.yllu.SaltEdgeClientE2E.configuration.WebDriverConfiguration;
import io.vavr.control.Try;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;

@Data
@Slf4j
@Component
public class FakeBankWithClientKeys {

    private final WebDriver webDriver;

    public FakeBankWithClientKeys() {
        webDriver = WebDriverConfiguration.chromeDriver();
    }

    public String startWidgetHappyFlow(String connectUrl) {
        FirstPage firstPage = new FirstPage(webDriver);
        firstPage.navigateTo(connectUrl);

        return Try.of(firstPage::clickProceed)
                .mapTry(ConsentPage::clickGiveConsent)
                .mapTry(FlowSelectionPage::clickGrantAccess)
                .mapTry(ReturnToApplicationPage::clickReturnToApplication)
                .andThen(this::stopDriver)
                .get();
    }

    private void stopDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private class FirstPage extends BasePage {

        private final static String PROCEED_BUTTON_CLASS = "btn-signup";
        private final static String CANCEL_BUTTON_CLASS = "btn-white";

        @FindBy(className = PROCEED_BUTTON_CLASS)
        public WebElement proceedElement;

        @FindBy(className = CANCEL_BUTTON_CLASS)
        public WebElement cancelElement;


        private FirstPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        private ConsentPage clickProceed() {
            System.out.println("Clicking the Proceed button");

            run(() -> sleep(500))
                    .andThen(proceedElement::click);
            return new ConsentPage(webDriver);
        }

        private void clickCancel() {
            log.info("Clicking the Cancel button");
            run(() -> sleep(500))
                    .andThen(cancelElement::click);
        }
    }

    private class ConsentPage extends BasePage {

        private final static String CONFIRM_BUTTON_CLASS = "btn";

        @FindBy(className = CONFIRM_BUTTON_CLASS)
        public WebElement confirmElement;

        public ConsentPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public FlowSelectionPage clickGiveConsent() {
            System.out.println("Clicking the Confirm button");
            run(() -> sleep(500))
                    .andThen(confirmElement::click);

            return new FlowSelectionPage(webDriver);
        }
    }

    private class FlowSelectionPage extends BasePage {

        private final static String CLASS_GRANT_ACCESS = "btn-primary";
        private final static String LINK_TEXT_GRANT_ACCESS = "Grant access";

        @FindBy(xpath = "//a[contains(@class, '" + CLASS_GRANT_ACCESS + "') and contains(., '" + LINK_TEXT_GRANT_ACCESS + "')]")
        public WebElement grantAccessElement;

        public FlowSelectionPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public ReturnToApplicationPage clickGrantAccess() {
            System.out.println("Clicking the Grant access button");
            run(() -> sleep(500))
                    .andThen(grantAccessElement::click);
            return new ReturnToApplicationPage(webDriver);
        }
    }

    private class ReturnToApplicationPage extends BasePage {
        private final static String RETURN_TO_APPLICATION_CLASS = "btn-signup";

        @FindBy(className = RETURN_TO_APPLICATION_CLASS)
        public WebElement returnToApplicationElement;

        public ReturnToApplicationPage(WebDriver webDriver) {
            super(webDriver);
            PageFactory.initElements(webDriver, this);
        }

        public String clickReturnToApplication() {
            System.out.println("Clicking return back to application button");
            run(() -> sleep(10000))
                    .andThen(returnToApplicationElement::click);

            System.out.println("After clicking");
            while (!webDriver.getCurrentUrl().contains("https://exemple.com/")) {
                run(() -> sleep(1000));
            }
            return webDriver.getCurrentUrl();
        }
    }
}



