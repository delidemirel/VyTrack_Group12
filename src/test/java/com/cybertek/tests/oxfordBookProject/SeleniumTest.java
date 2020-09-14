package com.cybertek.tests.oxfordBookProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class SeleniumTest {

    static ArrayList<Book> bookList = new ArrayList<Book>();


    public static void pullBookList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/haticedeli/Desktop/OxfordList.csv"));
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(",");
                Book bookInfo = new Book(lineArr[0], Integer.parseInt(lineArr[1]), lineArr[2]);
                bookList.add(bookInfo);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException {
        TakesScreenshot srcShot = ((TakesScreenshot) webdriver);
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
        BufferedImage originalBufferedImage = ImageIO.read(srcFile);
        BufferedImage croppedImage = originalBufferedImage.getSubimage(318, 48, 1265, 930);
        ImageIO.write(croppedImage, "png", new File(fileWithPath));


//        File DestFile = new File(fileWithPath);
//        FileUtils.copyFile(new File(), DestFile);
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        SeleniumTest.pullBookList();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        for(int i=0; i<bookList.size();i++){
            driver.get(bookList.get(i).getLink());
            Thread.sleep(10000);
            Actions builder = new Actions(driver);
            String dir="/Users/haticedeli/IdeaProjects/seleniumprojecthdB20/"+bookList.get(i).getFolderName();
            File directory = new File(dir);
            if(!directory.exists()){
                directory.mkdir();
            }

            for (int j = 0; j<bookList.get(i).getNumOfPages(); j++) {
                builder.sendKeys(Keys.RIGHT).build().perform();
                Thread.sleep(500);
                SeleniumTest.takeSnapShot(driver, bookList.get(i).getFolderName()+"/test-" + j + ".png");
                Thread.sleep(500);
            }



        }




    }
}
