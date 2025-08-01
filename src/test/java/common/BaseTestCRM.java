package common;

import locators_element.cms.Locators_CMS_Login;
import locators_element.crm.Locators_CRM_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTestCRM {
    public WebDriver driver;
    public SoftAssert softAssert;

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
        // Khởi tạo SoftAssert để kiểm tra nhiều điều kiện
        softAssert = new SoftAssert();

        driver.get(Locators_CRM_Login.url);
//        System.out.println(driver.findElement(By.xpath(Locators_CRM_Login.titlePageLogin)).getText());

        driver.findElement(By.xpath(Locators_CRM_Login.inputEmailAddress)).clear();
        driver.findElement(By.xpath(Locators_CRM_Login.inputEmailAddress)).sendKeys(Locators_CRM_Login.email);
        driver.findElement(By.xpath(Locators_CRM_Login.inputPassword)).clear();
        driver.findElement(By.xpath(Locators_CRM_Login.inputPassword)).sendKeys(Locators_CRM_Login.password);
        driver.findElement(By.xpath(Locators_CRM_Login.buttonLogin)).click();

        List<WebElement> listMenu = driver.findElements(By.xpath(Locators_CRM_Login.linkMenuDashboard));
        Assert.assertTrue(listMenu.size() > 0, "Đăng nhập CRM thất bại!");
    }

    @AfterMethod
    public void logoutCMS() {
        driver.findElement(By.xpath(Locators_CRM_Login.iconProfileAdmin)).click();
        driver.findElement(By.xpath(Locators_CRM_Login.buttonLogout)).click();

        List<WebElement> headerPageLogin = driver.findElements(By.xpath(Locators_CRM_Login.titlePageLogin));
        softAssert.assertTrue(headerPageLogin.size() > 0, "Đăng xuất CRM thất bại!");

        softAssert.assertAll();
    }
}
