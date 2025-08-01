package locators_element.crm;

public class Locators_CRM_Login {
    //link CRM
    public static String url = "https://crm.anhtester.com/admin/authentication";
    public static String email = "admin@example.com";
    public static String password = "123456";

    //Locators
    public static String titlePageLogin = "//h1[normalize-space()='Login']";

    public static String inputEmailAddress = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";

    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";

    public static String errorMessageInvalid = "//div[@id='alerts']";
    public static String errorMessageRequiredEmail = "//div[normalize-space()='The Email Address field is required.']";
    public static String errorMessageRequiredPassword = "//div[normalize-space()='The Password field is required.']";

    //link menu Dashboard
    public static String linkMenuDashboard = "//span[normalize-space()='Dashboard']/parent::a";

    public static String iconProfileAdmin = "//li[@class='icon header-user-profile']";
    public static String buttonLogout = "//a[text()='Logout']";
}
