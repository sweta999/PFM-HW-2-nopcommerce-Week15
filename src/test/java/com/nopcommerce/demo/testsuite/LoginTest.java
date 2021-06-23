package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static String email = "test" + Utility.generateRandomNumber() + "@gmail.com";

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpLoginTest(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyErrorMessageWithInvalidCredentials() throws InterruptedException {
        homePage.clickOnLoginLink();
        Thread.sleep(1000);
        loginPage.setEnterEmail(email);
        loginPage.setEnterPassword("sonababy97");
        loginPage.clickLoginButton();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n"+
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test(groups = {"regression"})
    public void verifyLoginIsSuccessFull() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.setEnterEmail("sona@gmail.com");
        loginPage.setEnterPassword("sonababy97");
        Thread.sleep(1000);
        loginPage.clickLoginButton();
        String expectedMessage = "Welcome to our store";
        String actualMessage = loginPage.getLoginSuccessfull();
        Assert.assertEquals(actualMessage,expectedMessage);
    }



}
