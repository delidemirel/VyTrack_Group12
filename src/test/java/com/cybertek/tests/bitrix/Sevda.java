package com.cybertek.tests.bitrix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Sevda {

    static WebDriver driver;

    @BeforeMethod
    public static void setupMethod() {

        System.setProperty("WebDriverManager.chromedriver", "chromedriver");
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");

        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk12@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    @Test
    public void us2_ac9()  {


        //It goes to Task module
        //WebElement task = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        // WebElement task = driver.findElement(By.xpath("//span[.='Task']"));
        // WebElement task = driver.findElement(By.partialLinkText("Tasks"));

        WebElement task = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        task.click();


    }
    @AfterMethod
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
