package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpRegistrationTest() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserNavigateToRegistrationPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedMessage = "Register";
        String actualMessage = registerPage.setVerifyRegisterPage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyErrorMessageWithFirstNameEmptyForRegistration() throws InterruptedException {
        homePage.clickOnRegisterLink();
        Thread.sleep(1000);
        //registerPage.setSelectMale();
        registerPage.setSelectFemale();
        registerPage.setFirstName("");
        registerPage.setLastName("Mathur");
        registerPage.setDateOfBirthDay("25");
        registerPage.setDateOfBirthMonth("6");
        registerPage.setDateOfBirthYear("1997");
        registerPage.setEnterEmail("sona@gmail.com");
        //registerPage.setClearNewsletterBox();
        registerPage.setEnterPassword("sonababy97");
        registerPage.setEnterConfirmPassword("sonababy97");
        registerPage.setRegisterButton();
        String expectedMessage = "First name is required.";
        String actualMessage = registerPage.getTextEmptyFirstName();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(groups = {"regression"})
    public void verifyUserRegisteredSuccessfully() throws InterruptedException {
        homePage.clickOnRegisterLink();
        Thread.sleep(1000);
        registerPage.setSelectFemale();
        registerPage.setFirstName("Sona");
        registerPage.setLastName("Mathur");
        registerPage.setDateOfBirthDay("25");
        registerPage.setDateOfBirthMonth("6");
        registerPage.setDateOfBirthYear("1997");
        registerPage.setEnterEmail("sona@gmail.com");
        //registerPage.setClearNewsletterBox();
        registerPage.setEnterPassword("sonababy97");
        registerPage.setEnterConfirmPassword("sonababy97");
        registerPage.setRegisterButton();
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.getTextRegistrationComplete();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
