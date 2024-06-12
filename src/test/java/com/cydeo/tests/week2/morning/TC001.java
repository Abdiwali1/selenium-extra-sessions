package com.cydeo.tests.week2.morning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC001 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        // go to vytrack page
        driver.get("https://vytrack.com/");


        // verify Home, About us, Our Approach, Products and Services,
        // Contact and LOGIN labels are displayed
        WebElement home = driver.findElement(By.id("menu-item-844"));
        Assert.assertTrue(home.isDisplayed());

        Assert.assertTrue(driver.findElement(By.linkText("About us")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Our Approach")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Products and Services")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Contact")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("LOGIN")).isDisplayed());

    }


}
