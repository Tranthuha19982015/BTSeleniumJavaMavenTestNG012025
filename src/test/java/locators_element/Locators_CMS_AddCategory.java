package locators_element;

public class Locators_CMS_AddCategory {
    //link menu Product
    public static String linkmenuProduct = "//ul[@id='main-menu']//span[text()='Products']";

    //link menu Category
    public static String linkmenuCategory = "//ul[@id='main-menu']//span[text()='Category']";

    public static String titlePageCategory = "//h5[normalize-space()='Categories']";
    public static String inputSearchCategory = "//input[@id='search']";
    public static String categoryNameAfterAdding = "//table//td[2]";

    //button Add New Category
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']/parent::a";

    //Category Information
    public static String titleAddNewCategory = "//h5[normalize-space()='Category Information']";

    public static String inputCategoryName = "//input[@id='name']";

    public static String dropdownParentCategory = "//label[text()='Parent Category']/following-sibling::div/descendant::button[@role='combobox']";
    public static String inputSearchParentCategory = "//label[text()='Parent Category']/following-sibling::div/descendant::input[@type='search']";

    public static String inputOrderingNumber = "//input[@id='order_level']";

    public static String getDropdownType = "//label[text()='Type']/following-sibling::div/descendant::button[@role='combobox']";

    public static String selectType(String type) {
        String chooseType = "//label[text()='Type']/following-sibling::div//span[normalize-space()='" + type + "']";
        return chooseType;
    }

    public static String chooseFileBanner = "//label[text()='Banner ']/following-sibling::div/div[@data-toggle='aizuploader']";
    public static String chooseFileIcon = "//label[text()='Icon ']/following-sibling::div/div[@data-toggle='aizuploader']";

    public static String chooseFile(String file) {
        String chooseFile = "//div[@title='" + file + "']";
        return chooseFile;
    }

    public static String buttonAddFileBannerIcon = "//button[normalize-space()='Add Files']";

    public static String inputMetaTitle = "//input[@name='meta_title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";

    public static String dropdownFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//button[@role='combobox']";
    public static String inputSearchFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//input[@aria-label='Search']";

    public static String chooseFilteringAttributes(String filteringAttributes) {
        String chooseFilteringAttributes = "//span[text()='" + filteringAttributes + "']";
        return chooseFilteringAttributes;
    }

    public static String buttonSaveCategory = "//button[normalize-space()='Save']";
}
