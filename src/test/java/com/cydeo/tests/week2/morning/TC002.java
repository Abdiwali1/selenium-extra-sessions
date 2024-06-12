package com.cydeo.tests.week2.morning;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC002 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    @Test
    public void test1(){
        // 2-goto https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // 3-click Dropdown
        driver.findElement(By.linkText("Dropdown")).click();

        //   4-select Alabama from State Selection dropdown menu
        WebElement state = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(state);
        stateDropdown.selectByVisibleText("Alabama");


        //   5-verify Alabama is selected
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),"Alabama");
    }
}

