package com.cydeo.tests.week3.morning;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class Task01 {

    @Test
    public void test1() {

        WebDriver driver = Driver.getDriver();

        //Step 1- Go to the above URL.
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");


        //Step 2- Get the current window’s handle and write to the console window.
        // It must be the first window handle.
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        // Step 3- Click on “Visit W3Schools.com!” link
        // go to target frame
        driver.switchTo().frame("iframeResult");

        // locate the link and click it
        WebElement link = driver.findElement(By.linkText("Visit W3Schools.com!"));
        link.click();

        // Step 4- Verify total window handle number is 2.
        Set<String> handles = driver.getWindowHandles();
        Assert.assertEquals(handles.size(), 2);

        //Step 5- Switch to the second window.
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("W3Schools Online Web Tutorials")){
                break;
            }
        }

        //Step 6- Verify upper left side logo is displayed in second window.
        WebElement logo = driver.findElement(By.id("w3-logo"));
        Assert.assertTrue(logo.isDisplayed());

        // Step 7- Go back (Switch) to the first window.
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("W3Schools Tryit Editor")){
                break;
            }
        }

        //Step 8- Check the See Run Button Text. It must contain “Run >” text.
        WebElement runButton = driver.findElement(By.id("runbtn"));
        Assert.assertTrue(runButton.getText().contains("Run ❯"));



    }
}
