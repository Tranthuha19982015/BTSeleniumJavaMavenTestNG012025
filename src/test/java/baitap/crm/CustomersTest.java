package baitap.crm;

import common.BaseTestCRM;
import locators_element.crm.Locators_CRM_Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomersTest extends BaseTestCRM {
    @Test(priority = 1)
    public void addNewCustomer() throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String companyName = "Company HTest " + timestamp;

        driver.findElement(By.xpath(Locators_CRM_Customer.linkMenuCustomers)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CRM_Customer.buttonNewCustomer)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputCompany)).sendKeys(companyName);
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputVatNumber)).sendKeys("10");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputPhone)).sendKeys("0989569859");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputWebsite)).sendKeys("htest " + timestamp + ".com.vn ");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputSearchGroups)).sendKeys("hatran", Keys.ENTER);
        driver.findElement(By.xpath(Locators_CRM_Customer.dropdownGroups)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.dropdownDefaultLanguage)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.selectDefaultLanguage("Vietnamese"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputAddress)).sendKeys(timestamp + " Test Street, Test City");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputCity)).sendKeys(timestamp + "Test City");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputState)).sendKeys(timestamp + "Test State");
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CRM_Customer.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath(Locators_CRM_Customer.buttonSave)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CRM_Customer.linkMenuCustomers)).click();
        Thread.sleep(1000);
        //Kiểm tra đã thêm thành công
        driver.findElement(By.xpath(Locators_CRM_Customer.inputSearchCustomers)).sendKeys(companyName);
        Thread.sleep(2000);
        String actualCompanyName = driver.findElement(By.xpath(Locators_CRM_Customer.customerNameRow)).getText();
        softAssert.assertEquals(actualCompanyName, companyName, "FAILED. Thêm mới không thành công!!!");
    }
}
