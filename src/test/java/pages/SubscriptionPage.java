package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    private By mySpace = By.xpath(
            "//*[normalize-space()='MySpace' or normalize-space()='My Space']"
        );

    private By premium = By.xpath(
            "//*[normalize-space()='Premium']");

    // Payment Details
    private By paymentDetails = By.xpath(
            "//*[normalize-space()='Payment Details]");

    // Continue button
    private By continueButton = By.xpath(
            "//button[normalize-space()='Continue']"
           
    );

    // Subscription/plan page indicators
    private By subscriptionPage = By.xpath(
            "//*[contains(normalize-space(),'Subscription')"
            + " or contains(normalize-space(),'Choose a plan')"
            + " or contains(normalize-space(),'Select a plan')"
            + " or contains(normalize-space(),'Monthly')"
            + " or contains(normalize-space(),'Yearly')]"
    );

    public void clickMySpace() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(mySpace)
        );
        element.click();
    }

    public void selectPremium() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(premium)
        );
        element.click();
    }

    public void clickPaymentDetails() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(paymentDetails)
        );
        element.click();
    }

    public void clickContinue() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public boolean isSubscriptionPageDisplayed() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(subscriptionPage)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}