package com.cybertek.tests.bitrix;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");


        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk12@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();


    }

    @Test

    public void us1ac7() {

        WebElement message = driver.findElement(By.id("feed-add-post-form-tab-message"));
        message.click();
        WebElement visualEditor = driver.findElement(By.id("lhe_button_editor_blogPostForm"));
        visualEditor.click();

        String status = driver.findElement(By.className("bxhtmled-toolbar-cnt")).getCssValue("display");
        if(status.equalsIgnoreCase("none")){
            System.out.println("editor toolbar : hidden");
        }else{
            System.out.println("editor toolbar : visible");
        }


    }


    @Test
    public void us2ac5() {

        WebElement task = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        task.click();
        WebElement addMention = driver.findElement(By.id("bx-b-mention-task-form-lifefeed_task_form"));
        addMention.click();
        String statusAddMention = driver.findElement(By.id("BXSocNetLogDestination")).getCssValue("display");
        if (statusAddMention.equalsIgnoreCase("none")) {
            System.out.println("Add Mention Bar : Hidden");
        } else {
            System.out.println("Add Mention Bar : Visible");
        }
//       WebElement employeeAndDepartments= driver.findElement(By.id("destDepartmentTab_mention77550416"));
//        employeeAndDepartments.click();
//
//      WebElement cyberVetList= driver.findElement(By.className("bx-finder-company-department"));
//      cyberVetList.click();


        }


    @AfterMethod
    public void closeWebPage () throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    }
