package CrossBrowserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
    WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();
    EdgeOptions edgeOptions =  new EdgeOptions();

    @Parameters("browser")
    @BeforeTest
    public void initialize(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome is launched");
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge is launched");
        }
    }
    @Test
    public void ask_sherlock_login(){
        driver.get("https://www.google.com/");
        String ac = driver.getTitle();
        String ex = "Google";
        Assert.assertEquals(ac.contains("Google"), ex.contains("Google"));
    }
    public void f(){
    driver.quit();
    }
}
