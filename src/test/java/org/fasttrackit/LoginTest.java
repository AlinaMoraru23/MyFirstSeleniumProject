package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void validLoginTest() {


        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("alina.moraru.qa@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Pass23");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement myDashboard = driver.findElement(By.cssSelector(".dashboard h1"));
        Assert.assertEquals("MY DASHBOARD", myDashboard.getText());

    }


//    @AfterClass
//    public static void quit() {
//        driver.quit();


//    }
}