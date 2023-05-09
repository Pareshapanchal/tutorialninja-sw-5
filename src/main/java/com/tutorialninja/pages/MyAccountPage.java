package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath="//span[contains(text(),'My Account')]")
    WebElement myAccountlink ;
    @CacheLookup
    @FindBy(xpath="//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")
    WebElement myAccountlink1 ;
    @CacheLookup
    @FindBys (@FindBy(xpath="//div[@id='top-links']//li[contains(@class,'open')]/ul/li"))
    List<WebElement> listOfOptions ;
    @CacheLookup
    @FindBy(xpath="//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText ;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText ;
    @CacheLookup
    @FindBy(id="input-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id="input-lastname")
    WebElement lastName ;
    @CacheLookup
    @FindBy(id="input-email")
    WebElement emailField ;
    @CacheLookup
    @FindBy(id="input-telephone")
    WebElement telephone ;
    @CacheLookup
    @FindBy(id="input-password")
    WebElement password ;
    @CacheLookup
    @FindBy(id="input-confirm")
    WebElement confirmPassword ;
    @CacheLookup
    @FindBy(xpath="//label[normalize-space()='Yes']")
    WebElement subscribeRadioButton ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyCheckbox ;
    @CacheLookup
    @FindBy(xpath="//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton ;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accoutCreatedText ;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueButton2 ;
    @CacheLookup
    @FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/h1[1]")
    WebElement accountLogout ;
    @CacheLookup
    @FindBy(xpath="//a[contains(text(),'Continue')]")
    WebElement continueButton3 ;
    @CacheLookup
    @FindBy(xpath="//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton ;
    @CacheLookup
    @FindBy(xpath = "//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
    WebElement logout;
    public void clickOnLoginButton(){
        Reporter.log("Click on Login Button" );
        CustomListeners.test.log(Status.PASS,"Click on Login Button");
        clickOnElement(loginButton);
    }

    public void sendFirstNameLastName(String firstname, String lastname){
        Reporter.log("Enter First Name  "+firstname +"  And Last Name"+lastname );
        CustomListeners.test.log(Status.PASS,"Enter First Name  "+firstname +"  And Last Name"+lastname );

        sendTextToElement(firstName,firstname);
        sendTextToElement(lastName,lastname);
    }
    public void sendPassword(String password1){
        Reporter.log("Enter Password in passwordfield  "+ password1);
        CustomListeners.test.log(Status.PASS,"Enter Password in passwordfield  "+ password1);

        sendTextToElement(password,password1);
    }
    public void sendEmail(String email){

        Reporter.log("Enter Email Address "+ email );
        CustomListeners.test.log(Status.PASS,"Enter Email Address "+ email);

        sendTextToElement(emailField,email);
    }
    public void sendTelephone(String phone) {
        Reporter.log("Enter Telephone number "+phone );
        CustomListeners.test.log(Status.PASS,"Enter Telephone number "+phone);

        sendTextToElement(telephone,phone);
    }
    public void sendPasswordAndConfirmPassword(String password1, String confirmpassword){
        Reporter.log("Enter Passwrod "+password1+" Enter Confirm Password "+confirmpassword );
        CustomListeners.test.log(Status.PASS,"Enter Passwrod "+password1+" Enter Confirm Password "+confirmpassword);

        sendTextToElement(password,password1);
        sendTextToElement(confirmPassword,confirmpassword);
    }
    public void selectSubscribeRadioButton(String text){

        Reporter.log("Select Subscriber Radio Button " );
        CustomListeners.test.log(Status.PASS,"Select Subscriber Radio Button ");

        clickOnElement(subscribeRadioButton);
    }
    public void clickOnPrivacyPolicy() {
        Reporter.log("Check on PrivacyPolicy checkbox" );
        CustomListeners.test.log(Status.PASS,"Check on PrivacyPolicy checkbox");

        clickOnElement(privacyCheckbox);
    }
    public void clickOnContinueButton() {
        Reporter.log("Click on Continue button" );
        CustomListeners.test.log(Status.PASS,"Click on Continue button");

        clickOnElement(continueButton);
    }
    public String getAccountCreatedMessage() {
        Reporter.log("Get Account created message" );
        CustomListeners.test.log(Status.PASS,"Get Account created message");

        return getTextFromElement(accoutCreatedText);
    }
    public void clickOnContinueButton2() {
        Reporter.log("Click on Continue Button" );
        CustomListeners.test.log(Status.PASS,"Click on Continue Button");

        clickOnElement(continueButton2);
    }
    public String getAccountLogoutMessage(){
        Reporter.log("Get Account Logout message" );
        CustomListeners.test.log(Status.PASS,"Get Account Logout message");

        return getTextFromElement(accountLogout);

    }
    public void clickOnContinueButton3(){

        Reporter.log("Click on Continue button" );
        CustomListeners.test.log(Status.PASS,"Click on Continue button");

        clickOnElement(continueButton3);
    }
    public void clickOnMyAccountlink(){
        Reporter.log("Click on My Account tab" );
        CustomListeners.test.log(Status.PASS,"Click on My Account tab");
        clickOnElement(myAccountlink);
    }
    public void clickOnMyAccountTab(){
        Reporter.log("Click on My Account tab" );
        CustomListeners.test.log(Status.PASS,"Click on My Account tab");
        clickOnElement(myAccountlink1);
    }

    public String getReturningCustomerText(){
        Reporter.log("Get Returning Customer text" );
        CustomListeners.test.log(Status.PASS,"Get Returning Customer text");

        return getTextFromElement(returningCustomerText); }
    public String getRegisterAccountText(){
        Reporter.log("Get Register Account text" );
        CustomListeners.test.log(Status.PASS,"Get Register Account text");

        return getTextFromElement(registerAccountText);}
    public void clickOnLogout(){
        clickOnElement(logout);
    }
    public void selectMyAccountOptions(String option){
        Reporter.log("Select option from MyAccount" );
        CustomListeners.test.log(Status.PASS,"Select option from MyAccount");
        try {
            for (WebElement options : listOfOptions) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        }catch (StaleElementReferenceException e){
            System.out.println(listOfOptions);
        }

    }
}
