package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {
    @CacheLookup
    @FindBy(linkText="Desktops")
    WebElement desktop;
    @CacheLookup
    @FindBys(@FindBy(xpath= "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"))
    List<WebElement> options ;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(linkText="Laptops & Notebooks")
    WebElement laptopAndNoteBooks ;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/div[1]/a[1]")
    WebElement showAllLaptopsAndNotebooks;
    @CacheLookup
    @FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/h2[1]")
            //"//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopAndNoteBooksText ;
    @CacheLookup
    @FindBy(linkText="Components")
    WebElement components ;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Components')]")
    WebElement componentsText ;
    public void mouseHoverOnAndClickDesktops(){
        Reporter.log("Click on Desktops" );
        CustomListeners.test.log(Status.PASS,"Click on Desktops");
        mouseHoverToElementAndClick(desktop);
    }
    public void selectMenuAndClickShowAllDesktops(){
        Reporter.log("Click on Show AllDesktops" );
        CustomListeners.test.log(Status.PASS,"Click on Show AllDesktops");

        selectAndClickOnTheElementFromTheList(options,"Show AllDesktops");
    }
    public String getDesktopText(){

        Reporter.log("Get Desktop text" );
        CustomListeners.test.log(Status.PASS,"Get Desktop text");

        return getTextFromElement(desktopText);
    }
    public void mouseHoverOnLaptopsAndNoteBooks(){

        Reporter.log("Mouse hover on Laptops and Notebooks" );
        CustomListeners.test.log(Status.PASS,"Mouse hover on Laptops and Notebooks");

        mouseHoverToElement(laptopAndNoteBooks);
    }
    public void selectMenuAndClickShowAllLaptopsAndNoteBooks(){
        Reporter.log("Click on Show AllLaptops & Notebooks" );
        CustomListeners.test.log(Status.PASS,"Click on Show AllLaptops & Notebooks");

        mouseHoverToElementAndClick(showAllLaptopsAndNotebooks);
        //selectAndClickOnTheElementFromTheList(options,"Show AllLaptops & Notebooks");
    }
    public String getLaptopAndNoteBooksText(){
        Reporter.log("Get Laptop And Notbook Text" );
        CustomListeners.test.log(Status.PASS,"Get Laptop And Notbook Text");

        return  getTextFromElement(laptopAndNoteBooksText);
    }
    public void mouseHoverAndClickOnComponents(){

        Reporter.log("Click on Components" );
        CustomListeners.test.log(Status.PASS,"Click on Components");

        mouseHoverToElementAndClick(components);
    }
    public void selectMenuAndClickShowAllComponents(){
        Reporter.log("Click on Show AllComponents" );
        CustomListeners.test.log(Status.PASS,"Click on Show AllComponents");

        selectAndClickOnTheElementFromTheList(options,"Show AllComponents");
    }
    public String getComponentText(){
        Reporter.log("Get Componenet Text" );
        CustomListeners.test.log(Status.PASS,"Get Component Text");

        return getTextFromElement(componentsText);
    }

}
