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

    // My Space
    private By mySpace =
            By.xpath("//*[normalize-space()='My Space']");

    // Premium
    private By premium =
            By.xpath("//*[normalize-space()='Premium']");

    // Payment Details
    private By paymentDetails =
            By.xpath("//*[normalize-space()='Payment Details']");

    public SubscriptionPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }

    // Click My Space
    public void clickMySpace() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(mySpace)
        );

        element.click();

        // Wait for My Space menu to appear
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(mySpace)
        );
    }

    // Verify My Space
    public boolean isMySpaceDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            mySpace
                    )
            ).isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "My Space not displayed: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // Verify Premium
    public boolean isPremiumDisplayed() {

        try {

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            premium
                    )
            );

            System.out.println(
                    "Premium text found: " + element.getText()
            );

            return element.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Premium not found: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // Click Premium
    public void clickPremium() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(
                        premium
                )
        );

        element.click();
    }

    // Verify Payment Details
    public boolean isPaymentDetailsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            paymentDetails
                    )
            ).isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Payment Details not displayed: "
                    + e.getMessage()
            );

            return false;
        }
    }
}