package com.yllu.SaltEdgeClientE2E.pages_saltedge;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static io.vavr.control.Try.run;
import static java.lang.Thread.sleep;

@Slf4j
public class ApplicationPage extends BasePage {


    public ApplicationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String returnBackToApplication() {
        log.info("Clicking the Grant access button");
        run(() -> sleep(5000));

        while (!webDriver.getCurrentUrl().contains("https://exemple.com/")) {
            run(() -> sleep(1000));
        }
        return webDriver.getCurrentUrl();
    }
}
