package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // 1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String menu = "Show AllDesktops";
        selectMenu(menu);

        // 1.3 Verify the text ‘Desktops
        String expectedMessage1 = "Desktops";
        String actualMessage1 = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals("Error Message displayed", expectedMessage1, actualMessage1);

        clickOnMouseHoverOnElement(By.linkText("Desktops"));

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        String menu = "Show AllLaptops & Notebooks";
        selectMenu(menu);

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedMessage2 = "Laptops & Notebooks";
        String actualMessage2 = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        System.out.println(actualMessage2);
        Assert.assertEquals("Error Message displayed", expectedMessage2, actualMessage2);

        clickOnMouseHoverOnElement(By.className("dropdown-toggle"));

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        // 3.1 Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.linkText("Components"));

        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        String menu = "Show AllComponents";
        selectMenu(menu);

        //  3.3 Verify the text ‘Components’
        String expectedMessage3 = "Components";
        String actualMessage3 = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals("Error Message displayed", expectedMessage3, actualMessage3);
        System.out.println(actualMessage3);
        clickOnMouseHoverOnElement(By.className("dropdown"));

    }
    @After
       public void closeBrowser(){
        driver.close();
       }

}















