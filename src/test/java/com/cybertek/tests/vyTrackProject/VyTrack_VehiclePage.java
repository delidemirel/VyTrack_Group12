package com.cybertek.tests.vyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrack_VehiclePage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("User162");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).submit();
        if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.vytrack.com/user/login")) {
            System.out.println("Login Failed");
        } else {
            driver.findElement(By.linkText("Fleet")).click();
            Thread.sleep(1000L);

            driver.findElement(By.linkText("Vehicles")).click();
            if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation")) {
                System.out.println("Vehicles module : Success");
            } else {
                System.out.println("Vehicles module: Failed");
            }
        }
        driver.close();
    }
}
