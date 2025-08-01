package locators_element.crm;

public class Locators_CRM_Projects {
    //link menu Projects
    public static String linkMenuProjects = "//ul[@id='side-menu']/descendant::span[normalize-space()='Projects']/parent::a";

    public static String headerProjects = "//span[normalize-space()='Projects Summary']";

    public static String labelNotStarted = "//span[normalize-space()='Not Started']/preceding-sibling::span";
    public static String labelInProgress = "//span[normalize-space()='In Progress']/preceding-sibling::span";
    public static String labelOnHold = "//span[normalize-space()='On Hold']/preceding-sibling::span";
    public static String labelCancelled = "//span[normalize-space()='Cancelled']/preceding-sibling::span";
    public static String labelFinished = "//span[normalize-space()='Finished']/preceding-sibling::span";
    public static String inputSearchProjects = "//div[@id='projects_filter']/descendant::input[@type='search']";
    public static String projectsNameRow = "//table[@id='projects']/descendant::tbody/descendant::td[2]";

    //button Add New Projects
    public static String buttonNewProject = "//a[normalize-space()='New Project' and contains(@href,'project')]";

    //Locators Add New Projects
    //tab Project
    public static String headerAddProjects = "//h4[normalize-space()='Add new project']";

    public static String inputProjectName = "//input[@id='name']";
    public static String dropdownCustomer = "//button[@data-id='clientid']";
    public static String inputSearchCustomer = "//button[@data-id='clientid']/following-sibling::div/descendant::input[@type='search']";

    public static String selectCustomer(String customer) {
        String customerName = "//button[@data-id='clientid']/following-sibling::div/descendant::span[normalize-space()='" + customer + "']";
        return customerName;
    }

    public static String checkboxCalculateProgressThroughTasks = "//input[@id='progress_from_tasks']";
    public static String dropdownBillingType = "//button[@data-id='billing_type']";

    public static String selectBillingType(String billingType) {
        String selectBilling = "//button[@data-id='billing_type']/following-sibling::div/descendant::span[normalize-space()='" + billingType + "']";
        return selectBilling;
    }

    public static String dropdownStatus = "//button[@data-id='status']";

    public static String selectStatus(String status) {
        String chooseStatus = "//button[@data-id='status']/following-sibling::div/descendant::span[normalize-space()='" + status + "']";
        return chooseStatus;
    }

    public static String inputTotalRate = "//input[@id='project_cost']";
    public static String inputRatePerHour = "//input[@id='project_rate_per_hour']";
    public static String inputEstimatedHours = "//input[@id='estimated_hours']";
    public static String dropdownMembers = "//button[@data-id='project_members[]']";
    public static String inputSearchMembers = "//button[@data-id='project_members[]']/following-sibling::div/descendant::input[@type='search']";

    public static String selectMembers(String member) {
        String selectMember = "//button[@data-id='project_members[]']/following-sibling::div/descendant::span[normalize-space()='" + member + "']";
        return selectMember;
    }

    public static String inputTags = "//li[@class='tagit-new']";
    public static String iframeDescription = "//iframe[@id='description_ifr']";
    public static String checkboxSendProjectCreatedEmail = "//input[@id='send_created_email']";

    public static String buttonSave = "//div[@class='panel-footer text-right']//button[normalize-space()='Save']";
}
