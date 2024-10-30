import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class submit extends TestBase{

    @Test

    public void test_submit() throws InterruptedException {

        WebDriver driver = getDriver();

//        // Open LambdaTest's Selenium Playground
//        driver.get("https://www.lambdatest.com/selenium-playground");
//
//        // Maximize the window
//        driver.manage().window().maximize();
//

        try{
            // Open LambdaTest's Selenium Playground
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.manage().window().maximize();

            // Click "Input Form Submit" link
            WebElement inputFormSubmitLink = driver.findElement(By.linkText("Input Form Submit"));
            inputFormSubmitLink.click();

            // Fill in Name
            driver.findElement(By.name("name")).sendKeys("Gayan Jayawardhana");
            // Fill in Email
            driver.findElement(By.id("inputEmail4")).sendKeys("gayanpj1996@gmail.com");
            // Fill in Passwrod
            driver.findElement(By.id("inputPassword4")).sendKeys("@hfhdj");
            // Fill Company Name
            driver.findElement(By.id("company")).sendKeys("Company Name");
            // Fill City
            driver.findElement(By.id("inputCity")).sendKeys("Colombo");
            // Country Select
            Select countryDropdown = new Select(driver.findElement(By.name("country")));
            countryDropdown.selectByVisibleText("United States");
            // Fill Website
            driver.findElement(By.id("websitename")).sendKeys("abc.lk");
            // address 1
            driver.findElement(By.id("inputAddress1")).sendKeys("Colombo");
            //address 2
            driver.findElement(By.id("inputAddress2")).sendKeys("Colombo 2");
            //sate
            driver.findElement(By.id("inputState")).sendKeys("Westent");
            //zip Code
            driver.findElement(By.id("inputZip")).sendKeys("71000");

            // Submit the form after filling in all fields
            driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")).click();

            //Validation Result
            String ExpectedTitle = "Thanks for contacting us, we will get back to you shortly.";
            WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/p"));
            String ActualTitile = titleElement.getText();

            //print result
            System.out.println(ExpectedTitle);
            System.out.println(ActualTitile);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
