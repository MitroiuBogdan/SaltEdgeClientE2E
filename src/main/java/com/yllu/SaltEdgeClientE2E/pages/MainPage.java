package com.yllu.SaltEdgeClientE2E.pages;

import com.yllu.SaltEdgeClientE2E.properties.AppProperties;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BasePage implements BasePageTemplate {

    private final AppProperties appProperties;
    private final HomePage homePage;

    public MainPage(AppProperties appProperties,
                    HomePage homePage) {
        this.appProperties = appProperties;
        this.homePage = homePage;
    }

    public void performScenario() {
        navigate();
        homePage.ClickLogin();
    }

    @Override
    public void navigate() {
        String TITLE_XPATH = "//a[@href='/']";
        String URL = "http://eaapp.somee.com/";
        navigateTo(URL);
    }
}
