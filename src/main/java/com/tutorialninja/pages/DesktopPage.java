package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(linkText="Desktops")
    WebElement desktop;
    @CacheLookup
    @FindBys(@FindBy(xpath="//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"))
    List<WebElement> options;
    @CacheLookup
    @FindBys(@FindBy(xpath="//h4/a"))
    List<WebElement> products ;
    @CacheLookup
    @FindBys(@FindBy(xpath="//h4/a"))
    List<WebElement> products1 ;
    @CacheLookup
    @FindBy(id= "input-sort")
    WebElement sortBy ;
    @CacheLookup
    @FindBy(xpath="//span[normalize-space()='Currency']")
    WebElement currency ;
    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='£Pound Sterling']")
    WebElement poundSterling ;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'HP LP3065')]")
    WebElement hplp3065;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'HP LP3065')]")
    WebElement hplb3065Text;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'input-group date']//button")
    WebElement calenderButton;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement calenderMonthAndYear ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButtonOnCalender;
    @CacheLookup
    @FindBys(@FindBy(xpath="//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"))
    List<WebElement> datesOnCalender;
    @CacheLookup
    @FindBy(xpath="//button[@id='button-cart']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath="//input[@id='input-quantity']")
    WebElement quantity;
    @CacheLookup
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement productAddedText ;
    @CacheLookup
    @FindBy(xpath= "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement shoppingCartButton ;
    @CacheLookup
    @FindBy(xpath="//strong[normalize-space()='View Cart']")
    WebElement viewCartButton ;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartText ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productname ;
    @CacheLookup
    @FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/small[1]")
    WebElement deliveryDate ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement productModel;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total ;

    public void mouseHoverOnAndClickDesktops(){
        Reporter.log("Click on Desktops tab" );
        CustomListeners.test.log(Status.PASS,"Click on Desktops tab");
        mouseHoverToElementAndClick(desktop); }
    public void selectMenuAndClickShowAllDesktops(){
        Reporter.log("Click on Show AllDesktops" );
        CustomListeners.test.log(Status.PASS,"Click on Show AllDesktops");
        selectAndClickOnTheElementFromTheList(options,"Show AllDesktops");}
    public List<String> getExpectedProductsNameInZtoAOrder(){
        Reporter.log("Get Expected Produts Name after sorted Z to A order" );
        CustomListeners.test.log(Status.PASS,"Get Expected Produts Name after sorted Z to A order");

        List<String> list = getTheListOfElementFromTheList(products);
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }
    public void selectsortByOptionsFromDropDown(String text){
        Reporter.log("Sort by "+text );
        CustomListeners.test.log(Status.PASS,"Sort By"+text);
        selectByVisibleTextFromDropDown(sortBy,text);  }
    public List<String> getActualProductsNameInZtoAOrder(){
        Reporter.log("Get Actual Produts Name after sorted Z to A order" );
        CustomListeners.test.log(Status.PASS,"Get Actual Produts Name after sorted Z to A order");

        List<String> list;
           list = getTheListOfElementFromTheList(products1);
              System.out.println(list);

        return list;
    }
    public void clickOnCurrency(){
        Reporter.log("" );
        CustomListeners.test.log(Status.PASS,"");

        mouseHoverToElementAndClick(currency);    }
    public void selectPoundSterling(){
        Reporter.log("" );
        CustomListeners.test.log(Status.PASS,"");

        selectByContainsTextFromDropDown(poundSterling,"£Pound Sterling");    }
    public void clickOnHPLP3065(){
        Reporter.log("Click on HPLP3065" );
        CustomListeners.test.log(Status.PASS,"Click on HPLP3065");
        clickOnElement(hplp3065);    }
    public String getHPLP3065Text(){
        Reporter.log("Get HPLP3065 Text" );
        CustomListeners.test.log(Status.PASS,"Get HPLP3065 Text");
        return getTextFromElement(hplb3065Text);    }
    public void clickOnCalenderButton(){
        Reporter.log("Click On Calender Button" );
        CustomListeners.test.log(Status.PASS,"Click On Calender Button");
        clickOnElement(calenderButton);    }
    public void selectDateFromTheCalender(String year,String month, String date){
        Reporter.log("Select date from calender" );
        CustomListeners.test.log(Status.PASS,"Select date from calender");

        while (true) {
            String monthAndYear = getTextFromElement(calenderMonthAndYear);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOnCalender);
            }
        }
        List<WebElement> allDates = datesOnCalender;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void clickOnAddToCartButton(){
        Reporter.log("Click on AddToCart Button" );
        CustomListeners.test.log(Status.PASS,"Click On ADDTOCART button");
        clickOnElement(addToCartButton);
    }
    public String getProductAddedMessage(){
        Reporter.log("Get Product Added Message" );
        CustomListeners.test.log(Status.PASS,"Get Product Added Message");
        return getTextFromElement(productAddedText);
    }
    public String getShoppingCartText()
    {Reporter.log("Get Shopping Cart Text" );
        CustomListeners.test.log(Status.PASS,"Get Shopping Cart Text");
        return getTextFromElement(shoppingCartText);
    }
    public void changeQuantity(String qty){
        Reporter.log("Cahnge Quantity");
        CustomListeners.test.log(Status.PASS,"Change Quantity");
        clearTextFromField(quantity);
        sendTextToElement(quantity,qty);
    }
    public void clickOnShoppingCart(){
        Reporter.log("Click on Shopping Cart" );
        CustomListeners.test.log(Status.PASS,"Click on Shopping Cart");
        clickOnElement(shoppingCartButton); }
    public void clickOnViewCar(){
        Reporter.log("Click on View Cart" );
        CustomListeners.test.log(Status.PASS,"Click on View Cart");
        clickOnElement(viewCartButton);
    }
    public String getProductTitle(){
        Reporter.log("Get Product title" );
        CustomListeners.test.log(Status.PASS,"Get Product Title");
        return getTextFromElement(productname);}
    public String getDeliveryDate(){
        Reporter.log("Get Delivery Date" );
        CustomListeners.test.log(Status.PASS,"Get Delivery Date");
        return getTextFromElement(deliveryDate);}
    public String getProductModel(){
        Reporter.log("Get Product Model" );
        CustomListeners.test.log(Status.PASS,"Get product Model");
        return getTextFromElement(productModel);}
    public String getTotalText(){
        Reporter.log("Get Total" );
        CustomListeners.test.log(Status.PASS,"Get Total");
        return getTextFromElement(total);}
}
