package locators_element;

public class Locators_CMS_AddProduct {

    //Product Information
    public static String inputProductName = "//input[@name='name']";
    public static String dropdownCategory = "//button[@data-id='category_id']";
    public static String inputSearchCategory = "//label[text()='Category ']/following-sibling::div/descendant::input[@type='search']";
    public static String dropdownBrand = "//button[@data-id='brand_id']";
    public static String inputSearchBrand = "//label[text()='Brand']/following-sibling::div/descendant::input[@type='search']";
    public static String inputUnit = "//input[@name='unit']";
    public static String inputWeight = "//input[@name='weight']";
    public static String inputMinimumPurchaseQty = "//input[@name='min_qty']";
    public static String inputTags = "//tags[contains(@class,'tagify')]";
    public static String inputBarcode = "//input[@name='barcode']";

    //Product Images
    public static String inputGalleryImages = "//label[text()='Gallery Images ']/following-sibling::div/div[@data-type='image']";
    public static String inputThumbnailImage = "//label[text()='Thumbnail Image ']/following-sibling::div/div[@data-type='image']";

    public static String chooseFile(String file) {
        String chooseFile = "//span[text()='" + file + "']/ancestor::div[@class='card-body']";
        return chooseFile;
    }

    //Product Videos
    public static String dropdownVideoProvider = "//button[@data-id='video_provider']";
    public static String inputVideoLink = "//input[@name='video_link']";

    //Product Variation
    public static String toggleColors = "//input[@name='colors_active' and @type='checkbox']";
    public static String dropdownColors = "//button[@data-id='colors']";
    public static String inputSearchColors = "//button[@data-id='colors']/following-sibling::div/descendant::input[@type='search']";
    public static String dropdownAttributes = "//button[@data-id='choice_attributes']";
    public static String inputAttributes = "//button[@data-id='choice_attributes']/following-sibling::div/descendant::input[@type='search']";

    //Product price + stock
    public static String inputUnitPrice = "//input[@name='unit_price']";
    public static String inputDiscountDateRange = "//input[@name='date_range']";
    public static String inputDiscountPrice = "//input[@name='discount']";
    public static String dropdownDiscountType = "//select[@name='discount_type']/following-sibling::button";
    public static String inputQuantityPrice = "//input[@name='current_stock']";
    public static String inputSKU = "//input[@name='sku']";
    public static String inputExternalLink = "//input[@name='external_link']";
    public static String inputExternalLinkButtonText = "//input[@name='external_link_btn']";

    //Product Description

    //PDF Specification
    public static String inputPDFSpecification = "//label[normalize-space()='PDF Specification']/following-sibling::div//div[@data-type='document']";

    //SEO Meta Tags
    public static String inputMetaTitle = "//input[@name='meta_title']";
    public static String inputDescription = "//textarea[@name='meta_description']";
    public static String inputMetaImage = "//label[normalize-space()='Meta Image']/following-sibling::div/descendant::div[@data-type='image']";

    public static String chooseFileMetaImage(String file) {
        String fileMetaImage = "//span[normalize-space()='" + file + "']/ancestor::div[@class='card-body']";
        return fileMetaImage;
    }

    //Shipping Configuration

    //Low Stock Quantity Warning
    public static String getInputQuantityPriceWarning = "//input[@name='low_stock_quantity']";

    //Stock Visibility State
    public static String toggleStockQuantity = "//label[normalize-space()='Show Stock Quantity']/following-sibling::div/descendant::span";
    public static String toggleStockWithTextOnly = "//label[normalize-space()='Show Stock With Text Only']/following-sibling::div/descendant::span";
    public static String toggleHideStock = "//label[normalize-space()='Hide Stock']/following-sibling::div/descendant::span";

    //Cash on Delivery
    public static String toggleStatusCashOnDelivery = "//h5[normalize-space()='Cash on Delivery']/ancestor::div[@class='card']/descendant::span";

    //Featured
    public static String toggleStatusFeatured = "//h5[normalize-space()='Featured']/ancestor::div[@class='card']/descendant::span";

    //Todays Deal
    public static String toggleStatusTodaysDeal = "//h5[normalize-space()='Todays Deal']/ancestor::div[@class='card']/descendant::span";

    //Flash Deal
    public static String dropdownAddToFlash = "//button[@data-id='flash_deal']";
    public static String inputDiscountFlashDeal = "//input[@name='flash_discount']";
    public static String dropdownDiscountTypeFlash = "//button[@data-id='flash_discount_type']";

    //Estimate Shipping Time
    public static String inputShippingDays = "//input[@name='est_shipping_days']";

    //Vat & TAX
    public static String inputTax = "//input[@name='tax[]']";
    public static String dropdownFlatTax = "//label[normalize-space()='Tax']/following-sibling::div/descendant::button";

    //
    public static String buttonAddFile = "//button[normalize-space()='Add Files']";

    public static String buttonSaveAndUnpublish = "//div[@aria-label='Toolbar with button groups']/descendant::button[normalize-space()='Save & Unpublish']";
    public static String buttonSaveAndPublish = "//div[@aria-label='Toolbar with button groups']/descendant::button[normalize-space()='Save & Unpublish']";
}
