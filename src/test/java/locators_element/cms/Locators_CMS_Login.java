package locators_element.cms;

public class Locators_CMS_Login {
    //link CMS
    public static String url = "https://cms.anhtester.com/login";
    public static String email = "admin@example.com";
    public static String password = "123456";

    //Locators
    public static String titlePageLogin = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String subTitlePageLogin = "//p[normalize-space()='Login to your account.']";

    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";

    public static String checkboxRememberMe = "//span[normalize-space()='Remember Me']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    public static String errorMessage = "//span[text()='Invalid login credentials']/parent::div";
    //link menu Dashboard
    public static String linkMenuDashboard = "//ul[@id='main-menu']/descendant::span[normalize-space()='Dashboard']";

    public static String accountName = "//span[text()='Admin Example']/ancestor::a[@role='button']";
    public static String buttonLogout = "//a[contains(@href,'logout')]";
}
