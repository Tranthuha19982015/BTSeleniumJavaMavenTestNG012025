package baitap;

import common.BaseTest;
import locators_element.Locators_CMS_Category;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddCategory extends BaseTest {
    String categoryName;

    @Test(priority = 1)
    public void addCategory() throws InterruptedException {
        // Khởi tạo SoftAssert để kiểm tra nhiều điều kiện
        softAssert = new SoftAssert();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        categoryName = "Category HTest " + timestamp;

        //click vao menu Product
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuProduct)).click();
        //click vao menu Add Category
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuCategory)).click();
        Thread.sleep(1000);

        //Kiem tra title page Category
        String actualTitlePageCategory = driver.findElement(By.xpath(Locators_CMS_Category.titlePageCategory)).getText();
        String expectedTitlePageCategory = "All categories";
        softAssert.assertEquals(actualTitlePageCategory, expectedTitlePageCategory, "Title page Category không đúng");

        //Kiem tra title table Category
        String actualTitleTableCategory = driver.findElement(By.xpath(Locators_CMS_Category.titleTableCategory)).getText();
        softAssert.assertTrue(actualTitleTableCategory.equals("Categories"), "Title table Category không đúng");

        //Kiem tra header table Category
        List<WebElement> headerTable = driver.findElements(By.xpath(Locators_CMS_Category.headerTableCategory));
        String[] expectedHeaderTable = {"#", "Name", "Parent Category", "Order Level", "Level", "Banner", "Icon", "Featured", "Commission", "Options"};
        for (int i = 0; i < headerTable.size(); i++) {
            String actualHeader = headerTable.get(i).getText();
            softAssert.assertEquals(actualHeader, expectedHeaderTable[i], "Header table Category không đúng tại vị trí: " + (i + 1));
        }

        //click vao button Add New Category
        driver.findElement(By.xpath(Locators_CMS_Category.buttonAddNewCategory)).click();
        Thread.sleep(1000);
        String actualTitleAddNewCategory = driver.findElement(By.xpath(Locators_CMS_Category.titleAddNewCategory)).getText();
        softAssert.assertTrue(actualTitleAddNewCategory.equals("Category Information"), "Chưa chuyển hướng tới màn hình Add New Category");

        //Nhap thong tin Category
        driver.findElement(By.xpath(Locators_CMS_Category.inputCategoryName)).sendKeys(categoryName);
        Thread.sleep(1000);
        String actualCategoryName = driver.findElement(By.xpath(Locators_CMS_Category.inputCategoryName)).getAttribute("value");
        softAssert.assertTrue(actualCategoryName.equals(categoryName), "Không đúng giá trị Category Name đã điền");

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownParentCategory)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchParentCategory)).sendKeys("Sport shoes", Keys.ENTER);
        Thread.sleep(1000);
        String actualParentCategory = driver.findElement(By.xpath(Locators_CMS_Category.textParentCategory)).getText();
        softAssert.assertTrue(actualParentCategory.equals("Sport shoes"), "Không đúng giá trị Parent Category đã chọn");

        driver.findElement(By.xpath(Locators_CMS_Category.inputOrderingNumber)).sendKeys("2");
        Thread.sleep(1000);
        String actualOrderingNumber = driver.findElement(By.xpath(Locators_CMS_Category.inputOrderingNumber)).getAttribute("value");
        softAssert.assertTrue(actualOrderingNumber.equals("2"), "Không đúng giá trị Ordering Number đã điền");

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownType)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.selectType("Digital"))).click();
        Thread.sleep(1000);
        String actualType = driver.findElement(By.xpath(Locators_CMS_Category.textType)).getText();
        softAssert.assertTrue(actualType.equals("Digital"), "Không đúng giá trị Type đã chọn");

        driver.findElement(By.xpath(Locators_CMS_Category.inputChooseFileBanner)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFile("aodai"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputChooseFileIcon)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFile("nonla"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaTitle)).sendKeys("Category Test Meta Title");
        Thread.sleep(1000);
        String actualMetaTitle = driver.findElement(By.xpath(Locators_CMS_Category.inputMetaTitle)).getAttribute("value");
        softAssert.assertTrue(actualMetaTitle.equals("Category Test Meta Title"), "Không đúng giá trị Meta Title đã điền");

        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaDescription)).sendKeys("Category Test Meta Description");
        Thread.sleep(1000);
        String actualMetaDescription = driver.findElement(By.xpath(Locators_CMS_Category.inputMetaDescription)).getAttribute("value");
        softAssert.assertTrue(actualMetaDescription.equals("Category Test Meta Description"), "Không đúng giá trị Meta Description đã điền");

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchFilteringAttributes)).sendKeys("Size");
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFilteringAttributes("Size"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.labelFilteringAttributes)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_Category.buttonSaveCategory)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchCategory)).sendKeys(categoryName, Keys.ENTER);
        Thread.sleep(2000);
        String actualCategoryNameAdded = driver.findElement(By.xpath(Locators_CMS_Category.categoryNameRow)).getText();
        softAssert.assertEquals(actualCategoryNameAdded, categoryName, "Không đúng category đã thêm mới");

//        String actualMessageSuccess = driver.findElement(By.xpath(Locators_CMS_AddCategory.messageAddCategorySuccess)).getText();
//        System.out.println(actualMessageSuccess);
//        softAssert.assertTrue(actualMessageSuccess.equals("Category has been inserted successfully"), "Message thông báo add category không đúng");

        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void editCategory() throws InterruptedException {
        addCategory();

        driver.findElement(By.xpath(Locators_CMS_Category.buttonEditCategory)).click();
        String actualTitleEdit = driver.findElement(By.xpath(Locators_CMS_Category.titleAddNewCategory)).getText();
        softAssert.assertTrue(actualTitleEdit.equals("Category Information"), "Chưa chuyển hướng tới màn hình Edit New Category");

        driver.findElement(By.xpath(Locators_CMS_Category.inputCategoryName)).clear();
        driver.findElement(By.xpath(Locators_CMS_Category.inputCategoryName)).sendKeys(categoryName + "_edit");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownParentCategory)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchParentCategory)).sendKeys("No Parent", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputOrderingNumber)).clear();
        driver.findElement(By.xpath(Locators_CMS_Category.inputOrderingNumber)).sendKeys("3");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownType)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.selectType("Physical"))).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputChooseFileBanner)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFile("nonla"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputChooseFileIcon)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFile("aodai"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.buttonAddFileBannerIcon)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaTitle)).clear();
        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaTitle)).sendKeys("Category Test Meta Title Edit");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaDescription)).clear();
        driver.findElement(By.xpath(Locators_CMS_Category.inputMetaDescription)).sendKeys("Category Test Meta Description Edit ");
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.dropdownFilteringAttributes)).click();
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFilteringAttributes("Size"))).click();
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchFilteringAttributes)).sendKeys("Quality3");
        driver.findElement(By.xpath(Locators_CMS_Category.chooseFilteringAttributes("Quality3"))).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.buttonSaveCategory)).click();
        Thread.sleep(5000);

        String actualCategoryNameEdit = driver.findElement(By.xpath(Locators_CMS_Category.inputCategoryName)).getAttribute("value");
        softAssert.assertTrue(actualCategoryNameEdit.equals(categoryName + "_edit"), "Hiển thị sai giá trị Category Name đã Edit");

        String actualParentCategoryEdit = driver.findElement(By.xpath(Locators_CMS_Category.textParentCategory)).getText();
        softAssert.assertTrue(actualParentCategoryEdit.equals("No Parent"), "Hiển thị sai giá trị Parent Category đã Edit");

        String actualOrderingNumberEdit = driver.findElement(By.xpath(Locators_CMS_Category.inputOrderingNumber)).getAttribute("value");
        softAssert.assertTrue(actualOrderingNumberEdit.equals("3"), "Hiển thị sai giá trị Ordering Number đã Edit");

        String actualTypeEdit = driver.findElement(By.xpath(Locators_CMS_Category.textType)).getText();
        softAssert.assertTrue(actualTypeEdit.equals("Physical"), "Hiển thị sai giá trị Type đã Edit");

        String actualBannerEdit = driver.findElement(By.xpath(Locators_CMS_Category.bannerAfterChoose)).getText();
        softAssert.assertTrue(actualBannerEdit.equals("nonla"), "Hiển thị sai giá trị Banner đã Edit");

        String actualIconEdit = driver.findElement(By.xpath(Locators_CMS_Category.iconAfterChoose)).getText();
        softAssert.assertTrue(actualIconEdit.equals("aodai"), "Hiển thị sai giá trị Icon đã Edit");

        String actualMetaTitleEdit = driver.findElement(By.xpath(Locators_CMS_Category.inputMetaTitle)).getAttribute("value");
        softAssert.assertTrue(actualMetaTitleEdit.equals("Category Test Meta Title Edit"), "Hiển thị sai giá trị Meta Title đã Edit");

        String actualMetaDescriptionEdit = driver.findElement(By.xpath(Locators_CMS_Category.inputMetaDescription)).getAttribute("value");
        softAssert.assertTrue(actualMetaDescriptionEdit.equals("Category Test Meta Description Edit"), "Hiển thị sai giá trị Meta Description đã Edit");

        String actualFilteringAttributesEdit = driver.findElement(By.xpath(Locators_CMS_Category.textFilteringAttributes)).getText();
        softAssert.assertTrue(actualFilteringAttributesEdit.equals("Quality3"), "Hiển thị sai giá trị Filtering Attributes đã Edit");

        //click vao menu Add Category
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuCategory)).click();
        Thread.sleep(1000);

        //Tìm lại bản ghi sau khi edit
        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchCategory)).sendKeys(categoryName + "_edit", Keys.ENTER);
        Thread.sleep(2000);
        String actualCategoryNameAdded = driver.findElement(By.xpath(Locators_CMS_Category.categoryNameRow)).getText();
        softAssert.assertEquals(actualCategoryNameAdded, categoryName + "_edit", "Không đúng category đã cập nhật");
    }

    @Test(priority = 3)
    public void deleteCategory() throws InterruptedException {
        //click vao menu Product
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuProduct)).click();
        //click vao menu Add Category
        driver.findElement(By.xpath(Locators_CMS_Category.linkmenuCategory)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchCategory)).sendKeys(categoryName + "_edit", Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath(Locators_CMS_Category.buttonDeleteCategory)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(Locators_CMS_Category.buttonConfirmDelete)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(Locators_CMS_Category.inputSearchCategory)).sendKeys(categoryName + "_edit", Keys.ENTER);
        Thread.sleep(1000);
        List<WebElement> checkCategoryAfterDelete = driver.findElements(By.xpath(Locators_CMS_Category.categoryNameRow));
        softAssert.assertTrue(checkCategoryAfterDelete.size() <= 0, "Xóa Category không thành công!!!");
    }
}
