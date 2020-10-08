package com.cybertek.tests.vyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehicleCost {
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

            driver.findElement(By.linkText("Vehicle Costs")).click();
            if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.vytrack.com/entity/Extend_Entity_VehicleCosts")) {
                System.out.println("Vehicles Costs module : Success");
                Thread.sleep(5000);

                try {
                    driver.findElement(By.className("column-manager")).click();

                } catch (NoSuchElementException e) {
                    System.out.println("NoSuchElementException");

                }
                driver.findElement(By.id("column-c115")).click();
     //           System.out.println("close..");
                driver.findElement(By.className("column-manager")).click();

                driver.findElement(By.className("reset-action")).click();

            } else {
                System.out.println("Vehicles Costs module: Failed");
            }
        }
      //  driver.close();
    }
}

