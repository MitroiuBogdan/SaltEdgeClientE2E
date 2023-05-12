package com.yllu.SaltEdgeClientE2E.configuration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebDriverLibrary {


    @Primary
    @Bean
    public WebDriver webDriver() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
