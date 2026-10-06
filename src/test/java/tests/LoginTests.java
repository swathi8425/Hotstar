package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MySpacePage;

public class LoginTests extends BaseTest {

    @Test
    public void TC08_verifyLoginPage() {

        HomePage homePage = new HomePage(driver);

        // Step 1: Verify Home Page
        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        // Step 2: Open My Space
        MySpacePage mySpacePage = new MySpacePage(driver);

        mySpacePage.clickMySpace();

        // Step 3: Verify Login button
        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed in My Space"
        );

        // Step 4: Click Login
        mySpacePage.clickLogin();

        // Step 5: Create Login Page
        LoginPage loginPage = new LoginPage(driver);

        // Step 6: Verify Login Page
        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login Page is not displayed"
        );

        System.out.println("Login Page opened successfully");
    }


    @Test
    public void TC09_verifyMobileNumberField() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        // Home → My Space
        MySpacePage mySpacePage = new MySpacePage(driver);

        mySpacePage.clickMySpace();

        // My Space → Login
        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed"
        );

        mySpacePage.clickLogin();

        // Login Page
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isMobileNumberFieldDisplayed(),
                "Mobile number field is not displayed"
        );

        System.out.println("Mobile number field is displayed");
    }


    @Test
    public void TC10_verifyContinueButton() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        MySpacePage mySpacePage = new MySpacePage(driver);

        mySpacePage.clickMySpace();

        Assert.assertTrue(
                mySpacePage.isLoginDisplayed(),
                "Log In button is not displayed in My Space"
        );

        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login Page is not displayed"
        );

        // Enter mobile number before checking Continue button
        loginPage.enterMobileNumber("8742983378");

        Assert.assertTrue(
                loginPage.isContinueButtonDisplayed(),
                "Continue button is not displayed"
        );

        System.out.println("Continue button is displayed successfully");
    }
    @Test
    public void TC11_verifyLoginPageTitle() {

        HomePage homePage = new HomePage(driver);
        MySpacePage mySpacePage = new MySpacePage(driver);

        homePage.clickMySpace();
        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.getTitle() != null &&
                !loginPage.getTitle().isEmpty(),
                "Login page title is empty"
        );
    }

    @Test
    public void TC12_verifyMobileFieldEnabled() {

        HomePage homePage = new HomePage(driver);
        MySpacePage mySpacePage = new MySpacePage(driver);

        homePage.clickMySpace();
        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isMobileNumberFieldDisplayed(),
                "Mobile number field is not displayed"
        );
    }

    @Test
    public void TC13_enterMobileNumber() {

        HomePage homePage = new HomePage(driver);
        MySpacePage mySpacePage = new MySpacePage(driver);

        homePage.clickMySpace();
        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterMobileNumber("9876543210");

        Assert.assertTrue(
                loginPage.isContinueButtonDisplayed(),
                "Continue button is not displayed"
        );
    }

    @Test
    public void TC14_verifyContinueButtonAfterMobileNumber() {

        HomePage homePage = new HomePage(driver);
        MySpacePage mySpacePage = new MySpacePage(driver);

        homePage.clickMySpace();
        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterMobileNumber("9876543210");

        Assert.assertTrue(
                loginPage.isContinueButtonDisplayed(),
                "Continue button is not displayed"
        );
    }

    @Test
    public void TC15_verifyLoginPageURL() {

        HomePage homePage = new HomePage(driver);
        MySpacePage mySpacePage = new MySpacePage(driver);

        homePage.clickMySpace();
        mySpacePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login page is not displayed"
        );

        Assert.assertTrue(
                loginPage.getCurrentUrl().contains("login")
                        || loginPage.getCurrentUrl().contains("account"),
                "Login URL is incorrect: " + loginPage.getCurrentUrl()
        );
    }
}