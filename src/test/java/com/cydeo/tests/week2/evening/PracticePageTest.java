package com.cydeo.tests.week2.evening;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1-open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void dropdown_test(){
        //  2-goto https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //  3-click Dropdown
     //   driver.findElement(By.linkText("Dropdown")).click();

        BrowserUtils.clickLinks(driver,"Dropdown");


        //  4-select Alabama from State Selection dropdown menu
        Select select = new Select(driver.findElement(By.id("state")));

//        select.selectByIndex(1);
//        select.selectByValue("AL");
        select.selectByVisibleText("Alabama");


        //  5-verify Alabama is selected
        String expectedSelectedOption = "Alabama";
        String actualSelectedOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);
    }

}