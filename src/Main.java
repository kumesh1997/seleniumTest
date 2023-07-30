import Testing.LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/login/");
        LoginTest loginTest = new LoginTest();
        loginTest.GoogleHomepageResponsivenessTest(driver);
//        ResponsiveTest rs = new ResponsiveTest();
//        rs.validateResponsive();
        driver.close();
    }
}