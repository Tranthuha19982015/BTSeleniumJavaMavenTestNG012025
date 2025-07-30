package baitap;

import common.BaseTest;
import locators_element.Locators_CMS_AddProduct;
import locators_element.Locators_CMS_Category;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AddProduct extends BaseTest {

    @Test
    public void addProduct() throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        //Nhấn vào menu Products
        driver.findElement(By.xpath(Locators_CMS_AddProduct.linkMenuProducts)).click();

        // Mở trang Category để copy lấy tên category
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchCategory)).sendKeys("Category HTest 2025" + Keys.ENTER);
        Thread.sleep(2000);
        String categoryName = driver.findElement(By.xpath(Locators_CMS_Category.categoryNameRow)).getText();

        //Mở trang Add Product
        driver.findElement(By.xpath(Locators_CMS_AddProduct.linkMenuAddProduct)).click();
        Thread.sleep(1000);
        softAssert.assertEquals(driver.findElement(By.xpath(Locators_CMS_AddProduct.headerAddProduct)).getText(), "Add New Product",
                "Chưa mở được trang Add Product");

        //Điền thông tin sản phẩm
        Actions action = new Actions(driver);

        WebElement elementProductName = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputProductName));
        action.sendKeys(elementProductName, "Product HTest " + timestamp).perform();
        Thread.sleep(1000);

        WebElement elementCategory = driver.findElement(By.xpath(Locators_CMS_AddProduct.dropdownCategory));
        action.click(elementCategory).perform();
        Thread.sleep(1000);
        action.sendKeys(elementCategory, categoryName, Keys.ENTER).perform();
        Thread.sleep(1000);

        WebElement elementBrand = driver.findElement(By.xpath(Locators_CMS_AddProduct.dropdownBrand));
        action.click(elementBrand).perform();
        Thread.sleep(1000);
        action.sendKeys("NikeVTK", Keys.ENTER).perform();
        Thread.sleep(1000);

        WebElement elementUnit = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputUnit));
        action.sendKeys(elementUnit, "kg").perform();
        Thread.sleep(1000);

        WebElement elementWeight = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputWeight));
        action.click(elementWeight).perform();
        Thread.sleep(1000);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Select all text in the input field
        Thread.sleep(1000);
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform(); // Clear the input field
        action.sendKeys(elementWeight, "1.5").perform();
        Thread.sleep(1000);

        WebElement elementMinimumPurchaseQty = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputMinimumPurchaseQty));
        action.click(elementMinimumPurchaseQty).perform();
        Thread.sleep(1000);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Select all text in the input field
        Thread.sleep(1000);
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform(); // Clear the input field
        action.sendKeys(elementMinimumPurchaseQty, "50").perform();
        Thread.sleep(1000);

        WebElement elementTag = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputTags));
        action.sendKeys(elementTag, "Tag Product 1" + Keys.ENTER).sendKeys(elementTag, "Tag Product 2" + Keys.ENTER).perform();
        Thread.sleep(1000);

        WebElement elementBarcode = driver.findElement(By.xpath(Locators_CMS_AddProduct.inputBarcode));
        action.sendKeys(elementBarcode, "20025" + timestamp).perform();
        Thread.sleep(1000);
    }

}
