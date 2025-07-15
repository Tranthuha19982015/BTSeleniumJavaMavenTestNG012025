package BaiTap;

import common.BaseTest;
import locators_element.Locators_CMS_AddCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AddCategory extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        createDriver();

        loginCMS();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String categoryName = "Category Test " + timestamp;

        //click vao menu Product
        driver.findElement(By.xpath(Locators_CMS_AddCategory.linkmenuProduct)).click();
        //click vao menu Add Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.linkmenuCategory)).click();
        //click vao button Add New Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonAddNewCategory)).click();
        Thread.sleep(1000);
        //Nhap thong tin Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputCategoryName)).sendKeys(categoryName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.dropdownParentCategory)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchParentCategory)).sendKeys("Sport shoes", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputOrderingNumber)).sendKeys("2");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.getDropdownType)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.selectType("Digital"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFileBanner)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFile("aodai.jpg"))).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFileIcon)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFile("nonla.jpg"))).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputMetaTitle)).sendKeys("Category Test Meta Title");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputMetaDescription)).sendKeys("Category Test Meta Description");
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchFilteringAttributes)).sendKeys("Size");
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFilteringAttributes("Size"))).click();
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonSaveCategory)).click();
        Thread.sleep(1000);

        //Verify Category đã được thêm thành công
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Thread.sleep(2000);
        String categoryNameAdded = driver.findElement(By.xpath(Locators_CMS_AddCategory.categoryNameAfterAdding)).getText();
        if (categoryName.equals(categoryNameAdded)) {
            System.out.println("Thêm mới category thành công!");
        } else {
            System.out.println("Thêm mới category thất bại");
        }

        Thread.sleep(3000);
        closeDriver();
    }
}
