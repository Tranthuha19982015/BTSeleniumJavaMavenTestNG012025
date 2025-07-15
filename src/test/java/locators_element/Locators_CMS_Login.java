package locators_element;

public class Locators_CMS_Login {
    //link CMS
    public static String url = "https://cms.anhtester.com/login";
    public static String email = "admin@example.com";
    public static String password = "123456";

    //Locators
    public static String titlePageLogin = "//h1[contains(@class,'text-primary')]";

    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";

    public static String checkboxRememberMe = "//span[normalize-space()='Remember Me']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    public static String errorMessage = "//span[text()='Invalid login credentials']/parent::div";
}
