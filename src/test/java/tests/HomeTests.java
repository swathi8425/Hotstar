package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.MySpacePage;

public class HomeTests extends BaseTest {

    @Test
    public void TC01_verifyHomePageOpened() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );
    }

    @Test
    public void TC02_verifyHomePageURL() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.getCurrentUrl().contains("hotstar"),
                "Hotstar URL is incorrect"
        );
    }

    @Test
    public void TC03_verifyHomePageTitle() {

        HomePage homePage = new HomePage(driver);

        Assert.assertFalse(
                homePage.getTitle().isEmpty(),
                "Home Page title is empty"
        );
    }

    @Test
    public void TC04_verifyLoginButtonDisplayed() {

        HomePage homePage = new HomePage(driver);

        // Step 1: Verify Home Page
        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        // Step 2: Click My Space
        homePage.clickMySpace();

        // Step 3: Verify Log In inside My Space
        MySpacePage mySpacePage = new MySpacePage(driver);

        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed inside My Space"
        );

        System.out.println("Log In button is displayed successfully");
    }
}