import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LambdaTestSliderDemo extends TestBase{

    @Test

    public void test_login_page() throws InterruptedException {

        WebDriver driver = getDriver();

        // Open LambdaTest's Selenium Playground
        driver.get("https://www.lambdatest.com/selenium-playground");

        // Maximize the window
        driver.manage().window().maximize();

        // Click "Drag & Drop Sliders" link
        WebElement dragDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
        dragDropSlidersLink.click();

        // Locate the slider for "Default value 15"
        WebElement slider = driver.findElement(By.xpath("//input[@type='range' and @value='15']"));
        WebElement rangeValue = driver.findElement(By.id("range"));

        // Initialize Actions class
        Actions actions = new Actions(driver);

        // Drag the slider to the desired value
        while (!rangeValue.getText().equals("95")) {
            actions.dragAndDropBy(slider, 5, 0).perform();  // Adjusting in small steps to reach 95
        }

        // Validate that the range value shows 95
        Assert.assertEquals(rangeValue.getText(), "95", "The slider value is not set to 95.");

        // Close the browser
        //driver.quit();


    }
}