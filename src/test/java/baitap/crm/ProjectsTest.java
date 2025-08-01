package baitap.crm;

import common.BaseTestCRM;
import locators_element.crm.Locators_CRM_Customer;
import locators_element.crm.Locators_CRM_Projects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectsTest extends BaseTestCRM {
    @Test
    public void addNewProject() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        String projectName = "Project HTest " + timestamp;

        //Nhấn vào menu Customers
        WebElement elementMenuCustomers = driver.findElement(By.xpath(Locators_CRM_Customer.linkMenuCustomers));
        actions.click(elementMenuCustomers).perform();
        Thread.sleep(1000);

        WebElement elementInputSearchCustomers = driver.findElement(By.xpath(Locators_CRM_Customer.inputSearchCustomers));
        actions.sendKeys(elementInputSearchCustomers, "Company HTest").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        //Lấy customer name
        String customerName = driver.findElement(By.xpath(Locators_CRM_Customer.customerNameRow)).getText();

        //Nhấn vào menu Projects
        WebElement elementMenuProjects = driver.findElement(By.xpath(Locators_CRM_Projects.linkMenuProjects));
        actions.click(elementMenuProjects).perform();
        Thread.sleep(1000);

        //Kiểm tra tiêu đề trang
        boolean checkHeaderProjects = driver.findElements(By.xpath(Locators_CRM_Projects.headerProjects)).size() > 0;
        softAssert.assertTrue(checkHeaderProjects, "Chưa mở được trang Projects");

        //Nhấn vào nút New Project
        WebElement elementButtonNewProject = driver.findElement(By.xpath(Locators_CRM_Projects.buttonNewProject));
        actions.click(elementButtonNewProject).perform();
        Thread.sleep(1000);

        //Kiểm tra tiêu đề Add New Project
        boolean checkHeaderAddProject = driver.findElements(By.xpath(Locators_CRM_Projects.headerAddProjects)).size() > 0;
        softAssert.assertTrue(checkHeaderAddProject, "Chưa mở được trang Add New Project");

        //Điền thông tin Project
        WebElement elementProjectName = driver.findElement(By.xpath(Locators_CRM_Projects.inputProjectName));
        actions.sendKeys(elementProjectName, projectName).perform();
        Thread.sleep(500);

        WebElement elementCustomer = driver.findElement(By.xpath(Locators_CRM_Projects.dropdownCustomer));
        actions.click(elementCustomer).perform();
        Thread.sleep(500);
        WebElement elementSearchCustomer = driver.findElement(By.xpath(Locators_CRM_Projects.inputSearchCustomer));
        actions.sendKeys(elementSearchCustomer, customerName).perform();
        Thread.sleep(500);
        WebElement elementCustomerName = driver.findElement(By.xpath(Locators_CRM_Projects.selectCustomer(customerName)));
        actions.moveToElement(elementCustomerName).click(elementCustomerName).perform();
        Thread.sleep(500);

        WebElement elementCheckboxCalculateProgress = driver.findElement(By.xpath(Locators_CRM_Projects.checkboxCalculateProgressThroughTasks));
        actions.moveToElement(elementCheckboxCalculateProgress).click().build().perform();
    }
}
