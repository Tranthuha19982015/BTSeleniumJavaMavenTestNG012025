package common;

import locators_element.Locators_CMS_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Khởi tạo driver thành công, sẵn sàng chạy test!");
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng driver thành công!");
        }
    }

    @BeforeMethod
    public void loginCMS() {
        driver.get(Locators_CMS_Login.url);
        driver.findElement(By.xpath(Locators_CMS_Login.inputEmail)).clear();
        driver.findElement(By.xpath(Locators_CMS_Login.inputEmail)).sendKeys(Locators_CMS_Login.email);
        driver.findElement(By.xpath(Locators_CMS_Login.inputPassword)).clear();
        driver.findElement(By.xpath(Locators_CMS_Login.inputPassword)).sendKeys(Locators_CMS_Login.password);
        driver.findElement(By.xpath(Locators_CMS_Login.buttonLogin)).click();

        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@id='main-menu']/descendant::span[normalize-space()='Dashboard']"));
        if (listMenu.size() > 0) {
            System.out.println("Đăng nhập CMS thành công!");
        } else {
            System.out.println("Đăng nhập CMS thất bại!");
        }
    }

    @AfterMethod
    public void logoutCMS() {
        driver.findElement(By.xpath("//span[text()='Admin Example']/ancestor::a[@role='button']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

        List<WebElement> headerPageLogin = driver.findElements(By.xpath(Locators_CMS_Login.titlePageLogin));
        if (headerPageLogin.size() > 0) {
            System.out.println("Đăng xuất CMS thành công!");
        } else {
            System.out.println("Đăng xuất CMS thất bại!");
        }
    }
}
