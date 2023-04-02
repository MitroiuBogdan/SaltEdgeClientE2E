package com.yllu.SaltEdgeClientE2E.configuration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebDriverLibrary {




    //    @ConditionalOnMissingBean
//    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    @Bean
    public WebDriver webDriver() {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
