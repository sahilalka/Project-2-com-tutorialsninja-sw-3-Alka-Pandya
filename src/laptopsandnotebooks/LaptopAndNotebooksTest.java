package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilites.Utility;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException{
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.linkText("Show AllLaptops & Notebooks"));
        //1.3 Select Sort By "Price (High > Low)"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");
        Thread.sleep(3000);

        //1.4 Verify the Product price will arrange in High to Low order.
        ArrayList<String> actualList = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(By.xpath("//select[@id='input-sort']"));
        System.out.println("listOfElements=" + listOfElements);
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
            System.out.println(element.getText());
        }

        System.out.println("actual list = " + actualList);

        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
            System.out.println("expected list = " + element.getText());
        }

        System.out.println("expected list = " + expectedList);
    }
     @Test
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
         mouseHoverOnElement(By.linkText("Laptops & Notebooks"));

       //2.2 Click on “Show All Laptops & Notebooks”
         clickOnElement(By.linkText("Show AllLaptops & Notebooks"));

       //2.3 Select Sort By "Price (High > Low)"
         WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-sort']"));
         Select select = new Select(dropDown);
         select.selectByVisibleText("Price (High > Low)");
         Thread.sleep(3000);

       //2.4 Select Product “MacBook”
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='MacBook']"));

       //2.5 Verify the text “MacBook”
         String expectedMessage = "MacBook";
         String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
         System.out.println(actualMessage);
         Assert.assertEquals("Error Message displayed", expectedMessage, actualMessage);

       //2.6 Click on ‘Add To Cart’ button
          clickOnElement(By.xpath("//button[@id='button-cart']"));

       // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
         By actualText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
         System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        verifyElements (actualText, "Success: You have added MacBook to your shopping cart!");

      //2.8 Click on link “shopping cart” display into success message
         clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

       // 2.9 Verify the text "Shopping Cart"
         By actualText1 = By.xpath("//a[normalize-space()='shopping cart']");
         System.out.println(driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).getText());
        verifyElements(actualText1, "Shopping Cart");

      // 2.10 Verify the Product name "MacBook"
         By actualText2 = By.linkText("MacBook");
         System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='MacBook']")).getText());
        verifyElements(actualText2, "MacBook");

      //2.11 Change Quantity "2"
         clickOnElement(By.xpath("//input[@id='input-quantity']"));
         clearText(By.xpath("//input[@id='input-quantity']"));
         sendTextToTheElement(By.xpath("//input[@id='input-quantity']"), "2");

      // 2.12 Click on “Update” Tab
         clickOnElement(By.xpath("//input[@id='input-quantity']"));

      // 2.13 Verify the message “Success: You have modified your shopping cart!”
         By actualText3 = By.xpath("//div[@class='alert alert-success alert-dismissible']");
         System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        verifyElements(actualText3, "Success: You have modified your shopping cart!");

     // 2.14 Verify the Total £1204.00
         By total = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
         String message4 = driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).getText();
         System.out.println(message4);
         verifyElements(total, "$1204.00");

      // 2.15 Click on “Checkout” button
         clickOnElement(By.xpath("//h1[normalize-space()='Checkout']"));

      //  2.16 Verify the text “Checkout”
         By actualText5 = By.xpath("//h1[normalize-space()='Checkout']");
         System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Checkout']")).getText());
         verifyElements(actualText5, "Checkout");

      // 2.17 Verify the Text “New Customer”
         By actualText6 = By.xpath("//h2[normalize-space()='New Customer']");
         System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).getText());
         verifyElements(actualText6, "New Customer");

      //  2.18 Click on “Guest Checkout” radio button
       clickOnElement(By.xpath("//input[@value='guest']"));

     //   2.19 Click on “Continue” tab
         clickOnElement(By.xpath("//input[@id='button-account']"));

         Thread.sleep(2000);

         //2.20 Fill the mandatory fields
         sendTextToTheElement(By.name("firstname"),"Zara");
         sendTextToTheElement(By.name("lastname"),"Lee");
         sendTextToTheElement(By.id("input-payment-email"),"zara123@gmail.com");
         sendTextToTheElement(By.name("telephone"),"0779563425");
         sendTextToTheElement(By.name("address_1"),"190,Harrow view");
         sendTextToTheElement(By.id("input-payment-city"),"London");
         sendTextToTheElement(By.name("postcode"),"HA0 5AD");
         sendTextToTheElement(By.id("input-payment-country"),"United Kingdom");
         sendTextToTheElement(By.name("zone_id"),"Devon");

         //2.21 Click on “Continue” Button
         clickOnElement(By.xpath("//input[@id='button-guest']"));

         //2.22 Add Comments About your order into text area
         sendTextToTheElement(By.xpath("//textarea[@name='comment']"),"All is Well");

         //2.23 Check the Terms & Conditions check box
         clickOnElement(By.xpath("//input[@name='agree']"));

         //2.24 Click on “Continue” button
         clickOnElement(By.xpath("//input[@id='button-payment-method']"));

         //2.25 Verify the message “Warning: Payment method required!”

         WebElement elementMessage2 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
         String actual2 = elementMessage2.getText();
         System.out.println(actual2);
         String expected2 = "Warning: Payment method required!";

         System.out.println(expected2);
         boolean message2 = actual2.contains(expected2.trim());
         Assert.assertTrue(message2);
         Thread.sleep(2000);

    }

     }






