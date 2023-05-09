package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(linkText= "Laptops & Notebooks")
    WebElement laptopAndNoteBooks ;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNoteBooksText ;
    @CacheLookup
    @FindBys (@FindBy(xpath="//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"))
    List<WebElement> options ;
    @CacheLookup
    @FindBys (@FindBy(xpath="//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"))
    List<WebElement> options1 ;
    @CacheLookup
    @FindBys(@FindBy(xpath="//p[@class ='price']"))
    List<WebElement> price ;
    @CacheLookup
    @FindBys(@FindBy(xpath="//p[@class ='price']"))
    List<WebElement> price1 ;
    @CacheLookup
    @FindBy(id="input-sort")
    WebElement sortBy ;
    @CacheLookup
    @FindBy(linkText="MacBook")
    WebElement macbook ;
    @CacheLookup
    @FindBy(xpath="//button[@id='button-cart']")
    WebElement addToCartButton ;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'MacBook')]")
    WebElement macbookText;
    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement productAdded ;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
    @CacheLookup
    @FindBy(xpath="//strong[normalize-space()='View Cart']")
    WebElement viewCartButton ;
    @CacheLookup
    @FindBy(xpath="//div[@id='content']//h1")
    WebElement shoppingCartText ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macBookTitle;
    @CacheLookup
    @FindBy(xpath="//input[contains(@name, 'quantity')]")
    WebElement quantity ;
    @CacheLookup
    @FindBy(xpath="//i[@class='fa fa-refresh']")
    WebElement updateQuantity;//input[@name='quantity
    @CacheLookup
    @FindBy(xpath="//div[@id='checkout-cart']/div[1]")
    WebElement shoppingCartMessage;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total ;

    public void mouseHoverOnLaptopsAndNoteBooks(){
        Reporter.log("Click on Lpatops & Notebooks" );
        CustomListeners.test.log(Status.PASS,"Click on Lpatops & Notebooks");
        mouseHoverToElementAndClick(laptopAndNoteBooks);
    }
    public void selectMenuAndClickShowAllLaptopsAndNoteBooks(){
        Reporter.log("Click on Show AllLpatops & Notebooks" );
        CustomListeners.test.log(Status.PASS,"Click on Show AllLpatops & Notebooks");

        selectAndClickOnTheElementFromTheList( options,"Show AllLaptops & Notebooks");
    }
    public List<Double> getExpectedPriceInDescendingOrder(){
        Reporter.log("Get expected price list in decending order" );
        CustomListeners.test.log(Status.PASS,"Get expected price list in decending order");

        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : price) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }
    public List<Double> getActualPriceInDescendingOrder(){
        Reporter.log("Get actual price list in decending order" );
        CustomListeners.test.log(Status.PASS,"Get actual price list in decending order");

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : price1) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        return afterSortByPrice;
    }
    public void selectOptionFromSortByDropDown(String option){
        Reporter.log("SortBy " +option);
        CustomListeners.test.log(Status.PASS,"SortBY "+option);

        selectByVisibleTextFromDropDown(sortBy,option); }
    public void clickOnMacBook(){
        Reporter.log("Click on MacBook" );
        CustomListeners.test.log(Status.PASS,"Click on MacBook");

        clickOnElement(macbook);}
    public String getMacBookText(){
        Reporter.log("Get MacBook Text "+macbookText.getText() );
        CustomListeners.test.log(Status.PASS,"Get MacBook Text "+macbookText.getText());

        return getTextFromElement(macbookText);}
    public void clickOnAddToCartButton(){
        Reporter.log("Click on ADDTOCART button" );
        CustomListeners.test.log(Status.PASS,"Click on ADDTOCART button");

        clickOnElement(addToCartButton);}
    public String getProductAddedMessage(){
        Reporter.log("Get Product Added message "+productAdded.getText() );
        CustomListeners.test.log(Status.PASS,"Get Product Added Message "+ productAdded.getText());

        return getTextFromElement(productAdded);}
    public void clickOnShoppingCart(){
        Reporter.log("Click on Shopping Cart" );
        CustomListeners.test.log(Status.PASS,"Click on Shopping Cart");

        clickOnElement(shoppingCart);}
    public void clickOnViewCart(){
        Reporter.log("Click on ViewCart" );
        CustomListeners.test.log(Status.PASS,"Click on ViewCart");

        mouseHoverToElementAndClick(viewCartButton);}
    public String getShoppingCartText(){
        Reporter.log("Get Shopping Cart Text " +shoppingCartText.getText());
        CustomListeners.test.log(Status.PASS,"Get Shopping Cart Text "+shoppingCartText.getText());

        return getTextFromElement(shoppingCartText);}
    public String getMacBookTitle(){

        Reporter.log("Get MacBook Title "+macBookTitle.getText() );
        CustomListeners.test.log(Status.PASS,"Get MacBook Title  "+macBookTitle.getText());

        return getTextFromElement(macBookTitle);
    }
    public void changeQuantityField(String qty){
        Reporter.log("Change quantity to" +qty);
        CustomListeners.test.log(Status.PASS,"Change quantity to"+qty);

        clearTextFromField(quantity);
        sendTextToElement(quantity,qty);
    }
    public void clickOnUpdateButton(){
        Reporter.log("Click on Update" );
        CustomListeners.test.log(Status.PASS,"Click on Update ");

        clickOnElement(updateQuantity);}
    public String getShoppingCartMessage(){
        Reporter.log("Get ShoppintCartMessage" +shoppingCartMessage.getText());
        CustomListeners.test.log(Status.PASS,"Get ShoppintCartMessage  "+shoppingCartMessage.getText());

        return getTextFromElement(shoppingCartMessage);}
    public String getTotal(){
        Reporter.log("Get Total" );
        CustomListeners.test.log(Status.PASS,"Get Total");

        return getTextFromElement(total);}
}
