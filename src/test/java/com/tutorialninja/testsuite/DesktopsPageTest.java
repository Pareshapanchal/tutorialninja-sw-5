package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
DesktopPage desktopPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        desktopPage = new DesktopPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphabeticalOrder()throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        desktopPage.mouseHoverOnAndClickDesktops();
        //1.2 Click on “Show All Desktops”
        desktopPage.selectMenuAndClickShowAllDesktops();
        //get exptected products name before filter
        List<String> expectedNameList = desktopPage.getExpectedProductsNameInZtoAOrder();

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectsortByOptionsFromDropDown("Name (Z - A)");
        Thread.sleep(3000);
        // After filter Z -A Get all the products name and stored into array list
        List<String> actualNamelist;
        actualNamelist= desktopPage.getActualProductsNameInZtoAOrder();
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualNamelist,expectedNameList,"Product not sorted into Z to A order");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
       desktopPage.mouseHoverOnAndClickDesktops();
        //2.2 Click on “Show All Desktops”
        desktopPage.selectMenuAndClickShowAllDesktops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.selectsortByOptionsFromDropDown("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        desktopPage.clickOnHPLP3065();
        //2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(desktopPage.getHPLP3065Text(),"HP LP3065","HP LP3065 Product not display");
        //2.6 Select Delivery Date "2023-11-30"
        desktopPage.clickOnCalenderButton();
        Thread.sleep(2000);
        desktopPage.selectDateFromTheCalender("2023","November","30");
        //2.7.Enter Qty "1” using Select class.
        desktopPage.changeQuantity("1");
        //2.8 Click on “Add to Cart” button
        desktopPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String acctualMessage = desktopPage.getProductAddedMessage();
        String expectedMessage ="Success: You have added HP LP3065 to your shopping cart!";
        boolean message = acctualMessage.contains(expectedMessage.trim());
        Assert.assertTrue(message);
        //2.10 Click on link “shopping cart” display into success message
        desktopPage.clickOnShoppingCart();
        desktopPage.clickOnViewCar();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(desktopPage.getShoppingCartText().contains("Shopping Cart"));
        //2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals(desktopPage.getProductTitle(),"HP LP3065","Product name not matched");
        //2.13 Verify the Delivery Date "2022-11-30"
        System.out.println(desktopPage.getDeliveryDate());
        //Assert.assertTrue( desktopPage.getDeliveryDate().contains("2023-11-30"),"Delivery date not matched");
        //2.14 Verify the Model "Product21"
        Assert.assertEquals(desktopPage.getProductModel(),"Product 21", "Model not matched");
        //2.15 Verify the Todat "£74.73"
        Assert.assertEquals(desktopPage.getTotalText(),"$122.00","Total not matched");
    }

}
