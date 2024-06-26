package com.cydeo.tests.week3.evening;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Iframe_WindowHandleTest {

   @Test
   public void iframe_window_handle_test(){
       //Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
       //Test Scenario:
       //Step 1- Go to the above URL.
       Driver.getDriver().get(ConfigurationReader.getProperty("w3schools.url"));

       //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainWindow = Driver.getDriver().getWindowHandle();

        Driver.getDriver().switchTo().frame("iframeResult");

       //Step 3- Click on “Visit W3Schools.com!” link
       Driver.getDriver().findElement(By.linkText("Visit W3Schools.com!")).click();

       //Step 4- Verify total window handle number is 2.
       Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
       Assert.assertTrue(allWindowHandles.size()==2);

       //Step 5- Switch to the second window.
       for (String eachWindow : allWindowHandles) {
           Driver.getDriver().switchTo().window(eachWindow);
       }

       //Step 6- Verify upper left side logo is displayed in second window.
       WebElement logo = Driver.getDriver().findElement(By.xpath("//a[@id='w3-logo']/i"));
       Assert.assertTrue(logo.isDisplayed());

       //Step 7- Go back (Switch) to the first window.
       Driver.getDriver().switchTo().window(mainWindow);

       //Step 8- Check the See Run Button Text. It must contain “Run ❯” text.
       WebElement runBtn = Driver.getDriver().findElement(By.id("runbtn"));
       Assert.assertTrue(runBtn.getText().contains("Run ❯"));


       Driver.closeDriver();

   }
}
