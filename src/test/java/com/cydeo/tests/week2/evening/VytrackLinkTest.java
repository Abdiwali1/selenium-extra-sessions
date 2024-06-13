package com.cydeo.tests.week2.evening;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackLinkTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1-open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

     @Test
     public void vytrack_link_test(){

         //  2-goto https://vytrack.com/
         driver.get("https://vytrack.com/");

         //  3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN labels
         //  are displayed
         List<WebElement> allTopLinks = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));


         for (WebElement eachLink : allTopLinks) {
             Assert.assertTrue(eachLink.isDisplayed());
         }

         // Verification with using isDisplayed() is not going to be checking each text correctly
         // That is why we are using below way
        List<String> expectedLinks = new ArrayList<String>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));
        List<String> actualLinks = new ArrayList<>();

         for (WebElement eachLink : allTopLinks) {
             actualLinks.add(eachLink.getText());
         }

         Assert.assertEquals(actualLinks,expectedLinks);

     }

     @AfterMethod
     public void teardown(){

        driver.quit();

     }
}
