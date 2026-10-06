
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Login page elements
    private By mobileNumber =By.cssSelector("input[title='Mobile number']");

    
    private By continueButton =
    	    By.cssSelector("button[data-testid='otp-form-submit-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Verify Login Page
    public boolean isLoginPageDisplayed() {

        try {
            WebElement mobile = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(mobileNumber)
            );

            return mobile.isDisplayed();

        } catch (Exception e) {
            System.out.println("Login page not displayed: " + e.getMessage());
            return false;
        }
    }

    // Verify mobile number field
    public boolean isMobileNumberFieldDisplayed() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(mobileNumber)
            ).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // Enter mobile number
    public void enterMobileNumber(String number) {

        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mobileNumber)
        );

        mobile.clear();
        mobile.sendKeys(number);
    }

    // Verify Continue button
    public boolean isContinueButtonDisplayed() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(continueButton)
            ).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // Click Continue
    public void clickContinue() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );

        button.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}