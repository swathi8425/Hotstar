package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

   
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
       
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By searchButton =By.xpath("//*[contains(@aria-label,'Search') ]");
    

    public void clickSearch() {

        WebElement search = wait.until(
            ExpectedConditions.elementToBeClickable(searchButton)
        );

        search.click();
    }
}