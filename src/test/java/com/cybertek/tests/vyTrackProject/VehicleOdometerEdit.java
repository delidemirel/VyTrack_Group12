package com.cybertek.tests.vyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VehicleOdometerEdit {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");

        WebElement username = driver.findElement(By.name("_username"));
        WebElement password = driver.findElement(By.name("_password"));
        WebElement login = driver.findElement(By.id("_submit"));

        username.sendKeys("user162");
        Thread.sleep(2000);
        password.sendKeys("UserUser123");
        Thread.sleep(2000);
        login.click();
        Thread.sleep(1000);

        WebElement FleetModule = driver.findElement(By.className("dropdown-level-1"));
        FleetModule.click();
        Thread.sleep(2000);

        WebElement VehicleOdometer = driver.findElement(By.linkText("Vehicle Odometer"));
        VehicleOdometer.click();
        Thread.sleep(1000);
        List<WebElement> rowValues = driver.findElements(new By.ByLinkText("..."));
        Actions actions = new Actions(driver);
        actions.moveToElement(rowValues.get(0)).perform();
        List<WebElement> dots = driver.findElements(new By.ByXPath("/html/body/div[2]/div[2]/div/div[2]/div[3]/div[3]/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[7]/div[1]/div/a"));
        actions.moveToElement(dots.get(0)).perform();
        Thread.sleep(3000);
        List<WebElement> views = driver.findElements(new By.ByXPath("//a[@title=\"View\"]"));
        actions.moveToElement(views.get(0)).perform();
        views.get(0).click();
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://qa2.vytrack.com/entity/view/Extend_Entity_VehiclesOdometer/item/1989?grid[custom-entity-grid]=i%3D1%26p%3D25%26c%3Did0.OdometerValue1.Date1.Driver1.Units1.Model1%26v%3D__all__%26a%3Dgrid%26g%255Bclass_name%255D%3DExtend%255CEntity%255CVehiclesOdometer";
        if (actualLink.equals(expectedLink)) {
            System.out.println("User is able to click on View module");
        }
        Thread.sleep(3000);
        driver.navigate().back();
//        FleetModule.click();
//        VehicleOdometer.click();
//
//        try {actions.moveToElement(rowValues.get(0)).perform();
//        actions.moveToElement(dots.get(0)).perform();
//        List<WebElement> edits = driver.findElements(new By.ByXPath("//a[@title=\"Edit\"]"));
//        actions.moveToElement(edits.get(0)).perform();
//        edits.get(0).click();
//        Thread.sleep(3000);}catch (StaleElementReferenceException e){
//            System.out.println("error");
//        }
//
//
//        driver.navigate().back();
//        FleetModule.click();
//        VehicleOdometer.click();
//        actions.moveToElement(rowValues.get(0)).perform();
//        actions.moveToElement(dots.get(0)).perform();
//        List<WebElement> deletes = driver.findElements(new By.ByXPath("//a[@title=\"Delete\"]"));
//        actions.moveToElement(deletes.get(0)).perform();
//        deletes.get(0).click();
//        driver.findElement(By.className("btn cancel")).click();
//        Thread.sleep(3000);
//        driver.navigate().back();
//
//
//        driver.quit();
//

    }
}
