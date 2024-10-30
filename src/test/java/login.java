import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class login extends TestBase{

    @Test

    public void test_login_page() throws InterruptedException {

        WebDriver driver = getDriver();

        // Open LambdaTest's Selenium Playground
        driver.get("https://www.lambdatest.com/selenium-playground");

        // Maximize the window
        driver.manage().window().maximize();

        // Click "Simple Form Demo" link
        WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormDemoLink.click();

        // Validate that the URL contains "simple-form-demo"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("simple-form-demo"));
        Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");

        // Create a variable for the string value
        String message = "Welcome to LambdaTest";

        // Use this variable to enter values in the "Enter Message" textbox
        WebElement messageBox = driver.findElement(By.id("user-message"));
        messageBox.sendKeys(message);

        // Click "Get Checked Value" button
        WebElement getCheckedValueButton = driver.findElement(By.id("showInput"));
        getCheckedValueButton.click();

        // Validate whether the same text message is displayed in the "Your Message:" section
        WebElement displayedMessage = driver.findElement(By.id("message"));
        String displayedText = displayedMessage.getText();

        // Assertion to verify that displayed text is the same as the input message
        Assert.assertEquals(displayedText, message, "Displayed message does not match input message");

        // Close the browser
        driver.quit();

    }
}