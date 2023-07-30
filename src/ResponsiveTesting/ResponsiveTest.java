package ResponsiveTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

public class ResponsiveTest {
    @DataProvider
    public Object[][] mobileEmulation(){
        return new Object[][]{
                {"iPad Pro", 420, 600},
                {"Nexus 5", 360, 640},
                {"iPhone X", 375, 812},
                {"Pixel 2", 411,731},
                {"Galaxy S5", 360, 640},
                {"iPhone 8", 375, 667},
                {"iPhone 8 Plus", 414, 736},
                {"Galaxy S9", 360, 740},
                {"Pixel 3", 393, 786},
                {"iPad", 768, 1024},
                {"iPad Mini", 768, 1024},
                {"Nexus 7", 600, 960},
                {"Surface Pro", 1366, 768},
                {"Laptop with HD Resolution", 1366, 768}
        };
    }



    @Test(dataProvider = "mobileEmulation")
    public void validateResponsive(String emulation, int w, int h){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tharindu  Kumesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
        Map<String, String> deviceMobEmu = new HashMap<>();
        deviceMobEmu.put("deviceName", emulation);
        ChromeOptions chromeOpt = new ChromeOptions();
        chromeOpt.setExperimentalOption("mobileEmulation", deviceMobEmu);
        WebDriver driver = new ChromeDriver(chromeOpt);
        Dimension d = new Dimension(w,h);
        driver.manage().window().setSize(d);
        driver.get("http://localhost:3000/login/");
    }
}
