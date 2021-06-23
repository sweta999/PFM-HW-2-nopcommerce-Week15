package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    //Logger is class of Log4j. log is object created
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmail;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement enterPassword;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath ="//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")
    WebElement errorMessage;
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement WelcomeToOurStore;

    public String getWelcomeText() {
        Reporter.log("Verify The Text,Welcome, Please Sign In!" + welcomeText.toString() + "<br>");
        log.info(("Verify The Text,Welcome, Please Sign In! : " + welcomeText.toString()));
        return getTextFromElement(welcomeText);
    }

    public void setEnterEmail(String email) {
        Reporter.log("Entering email address : " + email + " to email field : " + enterEmail.toString() + "<br>");
        sendTextToElement(enterEmail, email);
        log.info("Entering email address : " + email + " to email field : " + enterEmail.toString());
    }

    public void setEnterPassword(String password) {
        Reporter.log("Entering password : " + password + " to password field : " + enterPassword.toString() + "<br>");
        sendTextToElement(enterPassword,password);
        log.info("Entering password : " + password + " to password field : " + enterPassword.toString());
    }

    public void clickLoginButton() {
        Reporter.log("Clicking on login button : " + loginButton.toString() + "<br>");
        clickOnElement(loginButton);
        log.info("Clicking on login button : " + loginButton.toString());
    }

    public String getErrorMessage() {
        Reporter.log("Verify the Text, Error Message : " + errorMessage.toString() + "<br>");
        log.info("Verify the Text, Error Message  : " + errorMessage.toString());
        return getTextFromElement(errorMessage);
    }

    public String getLoginSuccessfull() {
        Reporter.log("Verify the Text, Welcome To Our Store : " + WelcomeToOurStore.toString() + "<br>");
        log.info("Verify the Text, Welcome To Our Store  : " + WelcomeToOurStore.toString());
        return getTextFromElement(WelcomeToOurStore);

    }

}

