package Testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public void LoginTestWithValidCredentials(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("student");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        String at = driver.getTitle();
        String et = "Logged In Successfully | Practice Test Automation";
        if (at.equalsIgnoreCase(et)){
            System.out.println("Test successful with Valid Credentials");
        }else {
            System.out.println("Test Failed");
        }
    }

    public void LoginTestWithInvalidCredentials(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("stude");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        String at = driver.getTitle();
        String et = "Logged In Successfully | Practice Test Automation";
        if (!at.equalsIgnoreCase(et)){
            System.out.println("Test successful with Invalid Credentials");
        }else {
            System.out.println("Test failed with Invalid Credentials");
        }
    }


    public void GoogleHomepageResponsivenessTest(WebDriver webDriver){
        WebElement username = webDriver.findElement(By.xpath("//*[@id=\":r5:\"]"));
        WebElement password = webDriver.findElement(By.xpath("//*[@id=\":r7:\"]"));
        WebElement signInBtn = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div[5]/button"));
            try {
                // Set the initial window size to test responsiveness
                Dimension[] screenResolutions = {
                        new Dimension(1024, 768), // Change the resolutions as needed
                        new Dimension(1366, 768),
                        new Dimension(1920, 1080),
                        new Dimension(800, 600),
                        new Dimension(640, 480),
                        new Dimension(360, 740),
                        new Dimension(800, 600)
                };

                // Open Google homepage and check responsiveness at different screen resolutions
                for (Dimension resolution : screenResolutions) {
                    webDriver.manage().window().setSize(resolution);
                    Thread.sleep(1000);

                    // Perform any responsiveness testing logic here.
                    // You can check for specific elements or styles based on screen resolution.
                    boolean isSearchFieldPresent = username.isDisplayed();
                    System.out.println("Screen Resolution: " + resolution + " - Search field present: " + isSearchFieldPresent);

                    boolean isPasswordFieldPresent = password.isDisplayed();
                    System.out.println("Screen Resolution: " + resolution + " - Search field present: " + isPasswordFieldPresent);

                    boolean isBtnPresent = signInBtn.isDisplayed();
                    System.out.println("Screen Resolution: " + resolution + " - Search field present: " + isBtnPresent);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
