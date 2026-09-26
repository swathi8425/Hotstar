


package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Hotstar search input from your actual HTML
    private By searchInput = By.id("searchBar");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isSearchInputDisplayed() {
        try {
            WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
            );

            return input.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void enterSearch(String movieName) {

        // Wait until search input exists
        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(searchInput)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // IMPORTANT:
        // Do NOT use input.click()
        // Hotstar's backdrop intercepts the normal Selenium click.

        // Bring input into view
        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            input
        );

        // Focus the input using JavaScript
        js.executeScript(
            "arguments[0].focus();",
            input
        );

        // Clear existing text using JavaScript
        js.executeScript(
            "arguments[0].value = '';",
            input
        );

        // Type search text
        input.sendKeys(movieName);

        // Press ENTER
        input.sendKeys(Keys.ENTER);
    }
}