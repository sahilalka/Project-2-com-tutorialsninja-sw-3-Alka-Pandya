package desktops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilites.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void  verifyProductArrangeInAlphaBeticalOrder()throws InterruptedException {
        // 1.1 Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        //  1.2 Click on “Show All Desktops”
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        // 1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");

        // 1.4 Verify the Product will arrange in Descending order.
        ArrayList<String> actualList = new ArrayList<>();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='caption']//h4"));
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

        Thread.sleep(3000);
        // z -a
        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
        System.out.println("expected sort = " + expectedList);
        Collections.reverse(expectedList);

        System.out.println("expected reverse = " + expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        // 2.1 Mouse hover on Desktops Tab. and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        // 2.2 Click on “Show All Desktops”
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        // 2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");

        // 2.4 Select product “HP LP3065”
        clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        // 2.5 Verify the Text "HP LP3065"
        String expectedMessage = "HP LP3065";
        String actualMessage = getTextFromElement(By.cssSelector("div[id='content'] h1"));
        System.out.println(actualMessage);
        Assert.assertEquals("Error Message displayed", expectedMessage, actualMessage);
        Thread.sleep(2000);
        // 2.6 Select Delivery Date "2022-11-30"
        By deliveryDate = By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]");

        String message1 = driver.findElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]")).getText();
        System.out.println(message1);

        verifyElements(deliveryDate, "Delivery Date:2022-11-30");

        // 2.7.Enter Qty "1” using Select class.
        clickOnElement(By.xpath("//input[@id='input-quantity']"));

        // 2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        By actualText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        verifyElements(actualText, "Success: You have added HP LP3065 to your shopping cart!");

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));

        //2.11 Verify the text "Shopping Cart"
        By actualText1 = By.xpath("//a[contains(text(),'Shopping Cart')]");
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).getText());
       verifyElements(actualText1, "Shopping Cart");

        // 2.12 Verify the Product name "HP LP3065"
        By actualText2 = By.linkText("HP LP3065");
        System.out.println(driver.findElement(By.linkText("HP LP3065")).getText());
        verifyElements(actualText2, "HP LP3065");

        // 2.13 Verify the Delivery Date "2022-11-30"
        String message3 = driver.findElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]")).getText();
        System.out.println(message3);
       verifyElements(deliveryDate, "Delivery Date:2022-11-30");

        //2.14 Verify the Model "Product21"
        By actualText4 = (By.xpath("//td[normalize-space()='Product 21']"));
        System.out.println(driver.findElement(By.xpath("//td[normalize-space()='Product 21']")).getText());
       verifyElements(actualText4, "Product21");

        // 2.15 Verify the Total "$122.00"
        By total = By.xpath("(//td[contains(text(),'$122.00')])[4]");
        String message5 = driver.findElement(By.xpath("(//td[contains(text(),'$122.00')])[4]")).getText();
        System.out.println(message5);
       verifyElements(total, "$122.00");


    }
    public void closeBrowser(){
        driver.close();
    }


}
















