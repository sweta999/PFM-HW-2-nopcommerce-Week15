package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComputerTest extends TestBase {

    HomePage homePage;
    ComputerPage computerPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpComputerTest() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyNavigateToDesktopLinkSuccessfully() throws InterruptedException {
        homePage.clickOnComputersLink();
        Thread.sleep(1000);
        computerPage.clickOnDesktopLink();
        String expectedMsg = "Desktops";
        String actualMsg = computerPage.setGetTextForDesktops();
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyNavigateToNotebooksLinkSuccessfully() throws InterruptedException {
        homePage.clickOnComputersLink();
        Thread.sleep(1000);
        computerPage.clickOnNotebooksLink();
        String expectedMsg = "Notebooks";
        String actualMsg = computerPage.setGetTextForNotebooks();
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @Test(groups = {"regression"})
    public void verifyNavigateToSoftwareLinkSuccessfully() throws InterruptedException {
        homePage.clickOnComputersLink();
        Thread.sleep(1000);
        computerPage.clickOnSoftwareLink();
        String expectedMsg = "Software";
        String actualMsg = computerPage.setGetTextForSoftware();
        Assert.assertEquals(expectedMsg,actualMsg);
    }


}
