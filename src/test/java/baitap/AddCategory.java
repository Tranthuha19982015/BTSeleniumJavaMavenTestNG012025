package baitap;

import common.BaseTest;
import locators_element.Locators_CMS_AddCategory;
import locators_element.Locators_CMS_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddCategory extends BaseTest {
    @Test
    public void addCategory() throws InterruptedException {
        // Khởi tạo SoftAssert để kiểm tra nhiều điều kiện
        softAssert = new SoftAssert();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String categoryName = "Category HTest " + timestamp;

        //click vao menu Product
        driver.findElement(By.xpath(Locators_CMS_AddCategory.linkmenuProduct)).click();
        //click vao menu Add Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.linkmenuCategory)).click();
        Thread.sleep(1000);

        //Kiem tra title page Category
        String actualTitlePageCategory = driver.findElement(By.xpath(Locators_CMS_AddCategory.titlePageCategory)).getText();
        String expectedTitlePageCategory = "All categories";
        softAssert.assertEquals(actualTitlePageCategory, expectedTitlePageCategory, "Title page Category không đúng");

        //Kiem tra title table Category
        String actualTitleTableCategory = driver.findElement(By.xpath(Locators_CMS_AddCategory.titleTableCategory)).getText();
        softAssert.assertTrue(actualTitleTableCategory.equals("Categories"), "Title table Category không đúng");

        //Kiem tra header table Category
        List<WebElement> headerTable = driver.findElements(By.xpath(Locators_CMS_AddCategory.headerTableCategory));
        String[] expectedHeaderTable = {"#", "Name", "Parent Category", "Order Level", "Level", "Banner", "Icon", "Featured", "Commission", "Options"};
        for (int i = 0; i < headerTable.size(); i++) {
            String actualHeader = headerTable.get(i).getText();
            softAssert.assertEquals(actualHeader, expectedHeaderTable[i], "Header table Category không đúng tại vị trí: " + (i + 1));
        }

        //click vao button Add New Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonAddNewCategory)).click();
        Thread.sleep(1000);
        String actualTitleAddNewCategory = driver.findElement(By.xpath(Locators_CMS_AddCategory.titleAddNewCategory)).getText();
        softAssert.assertTrue(actualTitleAddNewCategory.equals("Category Information"), "Chưa chuyển hướng tới màn hình Add New Category");

        //Nhap thong tin Category
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputCategoryName)).sendKeys(categoryName);
        Thread.sleep(1000);
        String actualCategoryName = driver.findElement(By.xpath(Locators_CMS_AddCategory.inputCategoryName)).getAttribute("value");
        softAssert.assertTrue(actualCategoryName.equals(categoryName), "Không đúng giá trị Category Name đã điền");

        driver.findElement(By.xpath(Locators_CMS_AddCategory.dropdownParentCategory)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchParentCategory)).sendKeys("Sport shoes", Keys.ENTER);
        Thread.sleep(1000);
        String actualParentCategory = driver.findElement(By.xpath(Locators_CMS_AddCategory.parentCategoryAfterChoose)).getText();
        softAssert.assertTrue(actualParentCategory.equals("Sport shoes"), "Không đúng giá trị Parent Category đã chọn");

        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputOrderingNumber)).sendKeys("2");
        Thread.sleep(1000);
        String actualOrderingNumber = driver.findElement(By.xpath(Locators_CMS_AddCategory.inputOrderingNumber)).getAttribute("value");
        softAssert.assertTrue(actualOrderingNumber.equals("2"), "Không đúng giá trị Ordering Number đã điền");

        driver.findElement(By.xpath(Locators_CMS_AddCategory.getDropdownType)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.selectType("Digital"))).click();
        Thread.sleep(1000);
        String actualType = driver.findElement(By.xpath(Locators_CMS_AddCategory.getDropdownType)).getText();
        softAssert.assertTrue(actualType.equals("Digital"), "Không đúng giá trị Type đã chọn");

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
        String actualMetaTitle = driver.findElement(By.xpath(Locators_CMS_AddCategory.inputMetaTitle)).getAttribute("value");
        softAssert.assertTrue(actualOrderingNumber.equals("Category Test Meta Title"), "Không đúng giá trị Meta Title đã điền");

        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputMetaDescription)).sendKeys("Category Test Meta Description");
        Thread.sleep(1000);
        String actualMetaDescription = driver.findElement(By.xpath(Locators_CMS_AddCategory.inputMetaDescription)).getAttribute("value");
        softAssert.assertTrue(actualOrderingNumber.equals("Category Test Meta Description"), "Không đúng giá trị Ordering Number đã điền");

        driver.findElement(By.xpath(Locators_CMS_AddCategory.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchFilteringAttributes)).sendKeys("Size");
        driver.findElement(By.xpath(Locators_CMS_AddCategory.chooseFilteringAttributes("Size"))).click();
        driver.findElement(By.xpath(Locators_CMS_AddCategory.labelFilteringAttributes)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_AddCategory.buttonSaveCategory)).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath(Locators_CMS_AddCategory.inputSearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Thread.sleep(2000);
        String actualCategoryNameAdded = driver.findElement(By.xpath(Locators_CMS_AddCategory.categoryNameAfterAdding)).getText();
        softAssert.assertEquals(actualCategoryNameAdded, categoryName, "Không đúng category đã thêm mới");

//        String actualMessageSuccess = driver.findElement(By.xpath(Locators_CMS_AddCategory.messageAddCategorySuccess)).getText();
//        System.out.println(actualMessageSuccess);
//        softAssert.assertTrue(actualMessageSuccess.equals("Category has been inserted successfully"), "Message thông báo add category không đúng");

        Thread.sleep(2000);
    }
}
