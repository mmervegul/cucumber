package excelautomation;

import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorDemo extends TestBase {

    @Test
    public void test(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        // the command creates an alert on the page
//        jse.executeScript("alert('You are doing sth dangerous');");

        EmployeesFormPage employeesFormPage = new EmployeesFormPage();
        BrowserUtils.wait(2);
        // it will click on the employeesFormPage.male
        // first argument is js command, second argument is web element on which the command will be executed
        jse.executeScript(
                "arguments[0].click();",
                employeesFormPage.male);

        String name = "Kunkka";
        jse.executeScript(
                "arguments[0].setAttribute('value', '" + name + "')",
                employeesFormPage.firstName);

        // scroll down on a page
        jse.executeScript("window.scrollBy(0,1000)");

        // putting so that driver does not close quickly
        BrowserUtils.wait(10);
    }
}
