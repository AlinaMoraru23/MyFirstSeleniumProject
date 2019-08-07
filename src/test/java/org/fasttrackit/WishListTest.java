package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void addProductToWishlistNotLoggedIn() {
        driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement saleButton = driver.findElement(By.cssSelector("#header [class*='nav-5'] [class='level0 has-children']"));
        saleButton.click();
        driver.findElement(By.cssSelector("[class^='products-grid'] .item:first-child .link-wishlist")).click();

        WebElement loginTitle = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT",loginTitle.getText());
    }
    @Test
    public void addProductToWishListLoggedIn() {
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("[data-target-element='#header-account'] .label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("[title='Log In']"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("alina.moraru.qa@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Pass23");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement saleButton = driver.findElement(By.cssSelector("#header [class*='nav-5'] [class='level0 has-children']"));
        saleButton.click();


        driver.findElement(By.cssSelector("[class^='products-grid'] .item:first-child .link-wishlist")).click();

        WebElement myWishlist = driver.findElement(By.cssSelector(".page-title"));

        Assert.assertEquals("MY WISHLIST",myWishlist.getText());


    }


    @AfterClass
    public static void quit() {
        driver.quit();

    }
}
