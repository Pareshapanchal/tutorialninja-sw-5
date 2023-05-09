package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksPageTEst extends BaseTest {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
          laptopsAndNotebooksPage= new LaptopsAndNotebooksPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndNoteBooks();
        //1.2 Click on “Show AllLaptops & Notebooks”
        laptopsAndNotebooksPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        // Get all the products price and stored into array list
        List<Double> exptectedList = laptopsAndNotebooksPage.getExpectedPriceInDescendingOrder();
        System.out.println(exptectedList);
        Thread.sleep(2000);
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectOptionFromSortByDropDown("Price (High > Low)");
        Thread.sleep(2000);
        // After filter Price (High > Low) Get all the products price and stored into array list
        List<Double> actualPriceList= laptopsAndNotebooksPage.getActualPriceInDescendingOrder();
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(actualPriceList,exptectedList,"Product not sorted by price High to Low");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        // Select currency as £ Pound Sterling
        //clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        //selectByContainsTextFromListOfElements(By.xpath("//ul[@class = 'dropdown-menu']/li"), "£Pound Sterling");
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        laptopsAndNotebooksPage.mouseHoverOnLaptopsAndNoteBooks();
        //2.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooksPage.selectMenuAndClickShowAllLaptopsAndNoteBooks();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectOptionFromSortByDropDown("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.clickOnMacBook();
        //2.5 Verify the text “MacBook”
        Thread.sleep(2000);
        Assert.assertEquals(laptopsAndNotebooksPage.getMacBookText(),"MacBook","MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Thread.sleep(2000);
        Assert.assertTrue(laptopsAndNotebooksPage.getProductAddedMessage().contains("Success: You have added MacBook to your shopping cart!"),"Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.clickOnShoppingCart();
        //Thread.sleep(2000);
        // laptopsAndNoteBooksPage.clickOnViewCart();
        //2.9 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        Assert.assertTrue(laptopsAndNotebooksPage.getShoppingCartText().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(laptopsAndNotebooksPage.getMacBookTitle(),"MacBook","Product name not matched");
        //2.11 Change Quantity "2"
        Thread.sleep(2000);
        laptopsAndNotebooksPage.changeQuantityField("2");
        //2.12 Click on “Update” Tab
        laptopsAndNotebooksPage.clickOnUpdateButton();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(laptopsAndNotebooksPage.getShoppingCartMessage().contains("Success: You have modified your shopping cart!"),"Cart not modified");
        //2.14 Verify the Total £737.45

        Assert.assertEquals(laptopsAndNotebooksPage.getTotal(),"$1,204.00","Total not matched");


    }
}
