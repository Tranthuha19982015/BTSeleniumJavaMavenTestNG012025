package locators_element;

public class Locators_CMS_Category {
    //link menu Product
    public static String linkmenuProduct = "//ul[@id='main-menu']//span[text()='Products']/parent::a";

    //link menu Category
    public static String linkmenuCategory = "//ul[@id='main-menu']//span[text()='Category']";

    public static String titlePageCategory = "//h1[normalize-space()='All categories']";
    public static String titleTableCategory = "//h5[normalize-space()='Categories']";
    public static String inputSearchCategory = "//input[@id='search']";
    public static String categoryNameRow = "//table//td[2]";

    public static String headerTableCategory = "//thead/tr[@class='footable-header']//th";
    //button Add New Category
    public static String buttonAddNewCategory = "//span[normalize-space()='Add New category']/parent::a";

    //Category Information
    public static String titleAddNewCategory = "//h5[normalize-space()='Category Information']";

    public static String inputCategoryName = "//input[@id='name']";

    public static String dropdownParentCategory = "//label[text()='Parent Category']/following-sibling::div/descendant::button[@role='combobox']";
    public static String textParentCategory = "//label[text()='Parent Category']/following-sibling::div/descendant::div[@class='filter-option-inner']/div";

    public static String inputSearchParentCategory = "//label[text()='Parent Category']/following-sibling::div/descendant::input[@type='search']";

    public static String inputOrderingNumber = "//input[@id='order_level']";

    public static String dropdownType = "//label[text()='Type']/following-sibling::div/descendant::button[@role='combobox']";
    public static String textType = "//label[text()='Type']/following-sibling::div/descendant::div[@class='filter-option-inner-inner']";

    public static String selectType(String type) {
        String chooseType = "//label[text()='Type']/following-sibling::div//span[normalize-space()='" + type + "']";
        return chooseType;
    }

    public static String inputChooseFileBanner = "//label[text()='Banner ']/following-sibling::div/div[@data-toggle='aizuploader']";
    public static String inputChooseFileIcon = "//label[text()='Icon ']/following-sibling::div/div[@data-toggle='aizuploader']";

    public static String chooseFile(String file) {
        String chooseFile = "//span[text()='" + file + "']/ancestor::div[@class='card-body']";
        return chooseFile;
    }

    public static String buttonAddFileBannerIcon = "//button[normalize-space()='Add Files']";

    public static String inputMetaTitle = "//input[@name='meta_title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";

    public static String dropdownFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//button[@role='combobox']";
    public static String textFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div/descendant::div[@class='filter-option-inner-inner']";
    public static String inputSearchFilteringAttributes = "//label[normalize-space()='Filtering Attributes']/following-sibling::div//input[@aria-label='Search']";

    public static String labelFilteringAttributes = "//label[normalize-space()='Filtering Attributes']";

    public static String chooseFilteringAttributes(String filteringAttributes) {
        String chooseFilteringAttributes = "//span[text()='" + filteringAttributes + "']";
        return chooseFilteringAttributes;
    }

    public static String buttonSaveCategory = "//button[normalize-space()='Save']";

    public static String messageAddCategorySuccess = "//span[@data-notify='message']";

    //edit
    public static String buttonEditCategory = "//a[contains(@class,'btn-soft-primary') and @title='Edit']";

    public static String bannerAfterChoose = "//label[text()='Banner ']/following-sibling::div//span[contains(@class,'title')]";

    public static String iconAfterChoose = "//label[text()='Icon ']/following-sibling::div//span[contains(@class, 'title')]";
    //delete
    public static String buttonDeleteCategory = "//a[contains(@class,'btn-soft-danger') and @title='Delete']";

    public static String buttonConfirmDelete = "//a[@id='delete-link']";
    public static String buttonCancelDelete = "//button[normalize-space()='Cancel']";
}
