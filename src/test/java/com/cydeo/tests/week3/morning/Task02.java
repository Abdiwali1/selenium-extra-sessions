package com.cydeo.tests.week3.morning;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.util.*;

public class Task02 {

    WebDriver driver = Driver.getDriver();

    @Test
    public void test1() {

        //Step 1- Click on calendar
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        //Step 2- Get the text of all test data of tables
        driver.findElement(By.id("datepicker")).click();
        List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
        for (WebElement date : dates) {
            System.out.println(date.getText());
        }
        clickDate(5);


    }

    //Step 3- Click the specific date with creating dynamic method
    public void clickDate(int date){
        driver.findElement(By.id("datepicker")).click();
        List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
        dates.get(date-1).click();
    }
}
