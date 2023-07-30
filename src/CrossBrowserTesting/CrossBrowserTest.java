package CrossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver driver = null;
    String chromePath = "C:\\Users\\Tharindu  Kumesh\\Downloads\\chromedriver_win32\\chromedriver.exe";
    String edgePath = "C:\\Users\\Tharindu  Kumesh\\Downloads\\edgedriver_win64\\msedgedriver.exe";
    String firefoxPath = "";

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName){
        System.out.println( browserName +"is Compatible");

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",edgePath);
            driver = new EdgeDriver();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(4000);
    }

    @AfterTest
    public void teardown(){
        driver.close();
        System.out.println("Cross Browser Testing Successful !!!");
    }
}

