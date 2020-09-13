package com.cybertek.tests.vyTrackProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehicleOdometerTC_AC1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager212");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).submit();
        if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.vytrack.com/user/login")) {
            System.out.println("Login Failed");
        } else {

            driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer");
            String expectedText = "403. Forbidden";
            String actualText = driver.findElement(By.className("error-page-title")).getText();
            if (actualText.equals(expectedText)){
                System.out.println("Vehicle Odometer Page Unauthorized User Access is Denied : Success");
            } else {
                System.out.println("Vehicle Odometer Page Unauthorized User Access is Granted : Failed");
            }
        }
        Thread.sleep(3000);
        driver.close();
    }
}
