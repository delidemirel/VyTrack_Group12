package com.cybertek.tests.vyTrackProject;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class VehicleOdometerTC_AC2 {

    public static void main(String[] args) throws InterruptedException {
        String[][] unauthorizedUserInfo = {{"storemanager212", "UserUser123"}, {"salesmanager262", "UserUser123"}};
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i < unauthorizedUserInfo.length; i++) {
            driver.get("https://qa2.vytrack.com/user/login");
            driver.findElement(By.id("prependedInput")).sendKeys(unauthorizedUserInfo[i][0]);
            driver.findElement(By.id("prependedInput2")).sendKeys(unauthorizedUserInfo[i][1]);
            driver.findElement(By.id("_submit")).submit();
            if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.vytrack.com/user/login")) {
                System.out.println("Login Failed");
            } else {
                Thread.sleep(2000);
                List<WebElement> mainMenus = driver.findElements(new By.ByClassName("title-level-1"));
                Actions actions = new Actions(driver);
//                for(WebElement element : mainMenus){
//                    actions.moveToElement(element).perform();
//                    Thread.sleep(3000);
//                }
                actions.moveToElement(mainMenus.get(1)).perform();
                driver.findElement(By.linkText("Vehicle Odometer")).click();
                Thread.sleep(5000);

                
                String actualText="";
                String expectedText= "You do not have permission to perform this action.";

                try {
                    actualText = driver.findElement(By.id("flash-messages")).getText();
     //               System.out.println(actualText);

                } catch (NoSuchElementException e) {
                    System.out.println("NoSuchElementException");
                }

                if (actualText.contains(expectedText)) {
                    System.out.println("No Access to Vehicle Odometer for "+unauthorizedUserInfo[i][0]+" : Verified");
                }else{
                    System.out.println("No Access to Vehicle Odometer for "+unauthorizedUserInfo[i][0]+" : Not Verified");
                }
                Thread.sleep(2000);
                driver.findElement(By.className("fa-caret-down")).click();
                Thread.sleep(2000);
                driver.findElement(By.linkText("Logout")).click();
                Thread.sleep(3000);

            }

        }

       driver.close();

    }
}
