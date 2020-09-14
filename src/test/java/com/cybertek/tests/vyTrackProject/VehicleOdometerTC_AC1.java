package com.cybertek.tests.vyTrackProject;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VehicleOdometerTC_AC1 {

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
                driver.get("https://qa2.vytrack.com/entity/Extend_Entity_VehiclesOdometer");
                String expectedText = "403. Forbidden";
                String actualText = "";
                try {
                    actualText = driver.findElement(By.className("error-page-title")).getText();

                } catch (NoSuchElementException e) {
                    System.out.println("NoSuchElementException");
                }


                if (actualText.equals(expectedText)) {
                    System.out.println("Vehicle Odometer Page Unauthorized User " + unauthorizedUserInfo[i][0] + " Access is Denied : Success");
                } else {
                    System.out.println("Vehicle Odometer Page Unauthorized User " + unauthorizedUserInfo[i][0] + " Access is Granted : Failed");
                    continue;

                }

                Thread.sleep(2000);
                driver.findElement(By.className("btn-primary")).click();
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
