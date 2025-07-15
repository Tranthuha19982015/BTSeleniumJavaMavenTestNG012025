package common;

import locators_element.Locators_CMS_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Khởi tạo driver thành công, sẵn sàng chạy test!");
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng driver thành công!");
        }
    }

    public static void loginCMS() {
        driver.get(Locators_CMS_Login.url);
        driver.findElement(By.xpath(Locators_CMS_Login.inputEmail)).clear();
        driver.findElement(By.xpath(Locators_CMS_Login.inputEmail)).sendKeys(Locators_CMS_Login.email);
        driver.findElement(By.xpath(Locators_CMS_Login.inputPassword)).clear();
        driver.findElement(By.xpath(Locators_CMS_Login.inputPassword)).sendKeys(Locators_CMS_Login.password);
        driver.findElement(By.xpath(Locators_CMS_Login.buttonLogin)).click();
    }
}
