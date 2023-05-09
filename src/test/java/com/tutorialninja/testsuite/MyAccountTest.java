package com.tutorialninja.testsuite;

import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    MyAccountPage myAccountPage;
    public static String email;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        myAccountPage= new MyAccountPage(); }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException{
        //1.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountlink();
        //accountPage.print();
        Thread.sleep(2000);
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register”
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(myAccountPage.getRegisterAccountText(),"Register Account","Register page not displayed");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
     myAccountPage.clickOnMyAccountlink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(myAccountPage.getReturningCustomerText(),"Returning Customer","Login page not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserRegisterAccountSuccessfully()throws InterruptedException {
        //3.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountlink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountPage.selectMyAccountOptions("Register");
        //3.3 Enter First Name//3.4 Enter Last Name
        myAccountPage.sendFirstNameLastName("Minesh","Vyas");
        //3.5 Enter Email
        email ="Ram"+generateRandomNumber()+"@gmail.com";
        myAccountPage.sendEmail(email);
        //3.6 Enter Telephone
        myAccountPage.sendTelephone("07988112233");
        //3.7 Enter Password //3.8 Enter Password Confirm
        myAccountPage.sendPasswordAndConfirmPassword("vivek123","vivek123");
        //3.9 Select Subscribe Yes radio button
        myAccountPage.selectSubscribeRadioButton("Yes");
        //3.10 Click on Privacy Policy check box
       myAccountPage.clickOnPrivacyPolicy();
        //3.11 Click on Continue button
       myAccountPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(), "Your Account Has Been Created!", "Error");
        //3.13 Click on Continue button
        myAccountPage.clickOnContinueButton2();
        Thread.sleep(3000);
        //3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
       myAccountPage.clickOnLogout();
        //myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = myAccountPage.getAccountLogoutMessage();
        Assert.assertEquals(actualMessage,expectedMessage,"Not logged out");
        //3.17 Click on Continue button
        myAccountPage.clickOnContinueButton3();
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        myAccountPage.clickOnMyAccountlink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login”
        myAccountPage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        myAccountPage.sendEmail(email);
        //4.4 Enter Password
        myAccountPage.sendPassword("vivek123");
        //4.5 Click on Login button
        myAccountPage.clickOnLoginButton();
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccountTab();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.clickOnLogout();
        //myAccountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String expectedMessage = "Account Logout";
        String actualMessage = myAccountPage.getAccountLogoutMessage();
        Assert.assertEquals(actualMessage,expectedMessage,"Not logged out");
        //4.11 Click on Continue button
        myAccountPage.clickOnContinueButton3();
    }

}
