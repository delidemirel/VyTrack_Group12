package com.cybertek.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static void main(String[] args) {

    }

    public static WebDriver getDriver(String browserType) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        System.setProperty("webdriver.safari.driver","safaridriver");
        WebDriver driver = null;
        if(browserType.equalsIgnoreCase("chrome")) driver =new ChromeDriver();
        else if(browserType.equalsIgnoreCase("safari")) driver = new SafariDriver();
        else if(browserType.equalsIgnoreCase("firefox")) driver= new FirefoxDriver();

        return driver;
    }
}
