package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySpacePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // My Space
    private By mySpace =
            By.xpath("//*[normalize-space()='My Space']");

    // Log In button
    private By loginButton =
            By.xpath("//button[.//span[normalize-space()='Log In']]");

    // Backdrop
    private By backdrop =
            By.cssSelector("div[data-testid='backdropWidth']");

    public MySpacePage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    // Click My Space
    public void clickMySpace() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(mySpace)
        );

        element.click();
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

            return false;
        }
    }

    // Verify Log In
    public boolean isLoginDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            loginButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Click Log In
    public void clickLogin() {

        WebElement login = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginButton
                )
        );

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            loginButton
                    )
            ).click();

        } catch (org.openqa.selenium.ElementClickInterceptedException e) {

            System.out.println(
                    "Backdrop intercepted Login click."
            );

            try {

                WebElement overlay =
                        driver.findElement(backdrop);

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].style.display='none';",
                        overlay
                );

            } catch (Exception ex) {

                System.out.println(
                        "Backdrop not found."
                );
            }

            // Click Login using JavaScript
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    login
            );
        }
    }
}