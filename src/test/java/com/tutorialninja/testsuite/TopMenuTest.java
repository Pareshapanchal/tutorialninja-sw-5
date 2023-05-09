package com.tutorialninja.testsuite;


import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.TopMenuPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        topMenuPage= new TopMenuPage();}
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
         topMenuPage.mouseHoverOnAndClickDesktops();
        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
         topMenuPage.selectMenuAndClickShowAllDesktops();
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = topMenuPage.getDesktopText();
        Assert.assertEquals( actualText,expectedText,"Not navigate to Desktop page");
    }

   @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()throws InterruptedException {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
          topMenuPage.mouseHoverOnLaptopsAndNoteBooks();
          Thread.sleep(2000);
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
          topMenuPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        //2.3 Verify the text ‘Laptops & Notebooks’
        System.out.println(topMenuPage.getLaptopAndNoteBooksText());
        Assert.assertEquals("Laptops & Notebooks", topMenuPage.getLaptopAndNoteBooksText(),"Not navigate to Laptops and Notebooks page");

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        topMenuPage.mouseHoverAndClickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        topMenuPage.selectMenuAndClickShowAllComponents();
        //3.3 Verify the text ‘Components’

        Assert.assertEquals(topMenuPage.getComponentText(),"Components","Not navigate to Laptops and Notebooks page");

    }

}
