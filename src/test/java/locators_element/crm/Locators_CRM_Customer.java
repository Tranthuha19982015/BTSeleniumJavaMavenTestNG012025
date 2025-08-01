package locators_element.crm;

public class Locators_CRM_Customer {
    //link menu Customers
    public static String linkMenuCustomers = "//ul[@id='side-menu']/descendant::span[normalize-space()='Customers']/parent::a";

    public static String headerCustomers = "//span[normalize-space()='Customers Summary']";
    public static String labelTotalCustomers = "//span[normalize-space()='Total Customers']/preceding-sibling::span";
    public static String labelActiveCustomers = "//span[normalize-space()='Active Customers']/preceding-sibling::span";
    public static String labelInactiveCustomers = "//span[normalize-space()='Inactive Customers']/preceding-sibling::span";
    public static String labelActiveContacts = "//span[normalize-space()='Active Contacts']/preceding-sibling::span";
    public static String labelInactiveContacts = "//span[normalize-space()='Inactive Contacts']/preceding-sibling::span";
    public static String labelContactsLoggedInToday = "//span[normalize-space()='Contacts Logged In Today']/preceding-sibling::span";
    public static String inputSearchCustomers = "//div[@id='clients_filter']/descendant::input[@type='search']";
    public static String customerNameRow = "//table[@id='clients']/descendant::tbody/descendant::td[3]";

    //button Add New Customer
    public static String buttonNewCustomer = "//a[normalize-space()='New Customer' and contains(@href,'client')]";

    //Locators Add New Customer
    //tab Customer Details
    public static String headerTabCustomerDetails = "//a[normalize-space()='Customer Details']";

    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = "//input[@id='website']";
    public static String dropdownGroups = "//button[contains(@data-id,'groups_in')]";
    public static String inputSearchGroups = "//button[contains(@data-id,'groups_in')]/following-sibling::div/descendant::input[@type='search']";
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency = "//button[@data-id='default_currency']/following-sibling::div/descendant::input[@type='search']";
    public static String dropdownDefaultLanguage = "//button[@data-id='default_language']";

    public static String selectDefaultLanguage(String language) {
        String selectLanguage = "//span[normalize-space()='" + language + "']";
        return selectLanguage;

    }

    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following-sibling::div/descendant::input[@type='search']";

    public static String buttonSaveAndCreateContact = "//div[@id='profile-save-section']/button[normalize-space()='Save and create contact']";
    public static String buttonSave = "//div[@id='profile-save-section']/button[normalize-space()='Save']";
}
