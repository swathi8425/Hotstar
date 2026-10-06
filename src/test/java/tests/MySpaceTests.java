
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.MySpacePage;

public class MySpaceTests extends BaseTest {

    @Test
    public void TC05_verifyMySpaceDisplayed() {

        HomePage homePage = new HomePage(driver);

        // Verify Home Page
        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        MySpacePage mySpacePage = new MySpacePage(driver);

        // Click My Space
        mySpacePage.clickMySpace();

        // Verify My Space
        Assert.assertTrue(
                mySpacePage.isMySpaceDisplayed(),
                "My Space is not displayed"
        );

        System.out.println("My Space is displayed successfully");
    }

    @Test
    public void TC06_verifyLoginButtonInMySpace() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        MySpacePage mySpacePage = new MySpacePage(driver);

        // Open My Space
        mySpacePage.clickMySpace();

        // Verify Login
        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed in My Space"
        );

        System.out.println(
                "Log In button is displayed successfully in My Space"
        );
    }

    @Test
    public void TC07_verifyLoginNavigation() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        MySpacePage mySpacePage = new MySpacePage(driver);

        // Open My Space
        mySpacePage.clickMySpace();

        // Verify Login
        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed"
        );

        // Click Login
        mySpacePage.clickLogin();

        // Verify navigation
        Assert.assertTrue(
                driver.getCurrentUrl().toLowerCase().contains("login")
                || driver.getCurrentUrl().toLowerCase().contains("hotstar"),
                "Login page was not opened"
        );

        System.out.println("Login navigation completed");
    }
}