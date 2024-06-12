package com.cydeo.tests.week2.morning;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC003 {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
    }

    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/");


        driver.findElement(By.linkText("Radio Buttons")).click();


        Assert.assertTrue(driver.getTitle().contains("Radio buttons"));

        WebElement redButton = driver.findElement(By.id("red"));
        redButton.click();
        Assert.assertTrue(redButton.isSelected());


        WebElement footballButton = driver.findElement(By.id("football"));
        footballButton.click();
        Assert.assertTrue(footballButton.isSelected());

    }
}
