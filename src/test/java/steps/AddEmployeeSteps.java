package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.Message;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runners.SmokeRunner;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
       // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
      //  pimOption.click();
        click(dashboard.pimOption); //click from common methods, dashboard from pageInitilizer and pimOption from dashboardSteps
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
       // WebElement addEmployeeOption = driver.findElement(By.id("menu_pim_addEmployee"));
       // addEmployeeOption.click();
        click(dashboard.addEmployeeOption);
    }

    @When("user enter firstname and lastname")
    public void user_enter_firstname_and_lastname() {
      //  WebElement firstName = driver.findElement(By.id("firstName"));
      //  firstName.sendKeys("somah");
        sendText(addEmployee.firstNameField,"joshpan");

      //  WebElement lastName = driver.findElement(By.id("lastName"));
       // lastName.sendKeys("yuriaaa");
        sendText(addEmployee.lastNameField, "veranullah");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
      //  saveButton.click();
        click(addEmployee.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }


    @When("user enter {string} and {string}")
    public void user_enter_and(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

    @When("user enter {string} and {string} for adding multiple employees")
    public void user_enter_and_for_adding_multiple_employees(String firstNameValue, String lastNameValue) {
        sendText(addEmployee.firstNameField, firstNameValue);
        sendText(addEmployee.lastNameField, lastNameValue);
    }


        @When("user adds multiple employees and verify they are added successfully")
        public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
            List<Map<String, String>> employeeNames = dataTable.asMaps();

            //getting the map from list of maps
            for (Map<String, String> employee:employeeNames
            ) {
                //getting the  keys and values from every map
                String firstNameValue = employee.get("firstName");
                String middleNameValue = employee.get("middleName");
                String lastNameValue = employee.get("lastName");

                sendText(addEmployee.firstNameField, firstNameValue);
                sendText(addEmployee.lastNameField, lastNameValue);
                sendText(addEmployee.middleNameField, middleNameValue);
//HW verification
                WebElement empIDElem=driver.findElement(By.id("employeeId")); //
              String empID= empIDElem.getText(); //
                click(addEmployee.saveButton);
               click(dashboard.empListOption); //

               sendText(employeeList.empSearchIdField, empID);//
               click(employeeList.searchButton);//
                Assert.assertEquals();driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).getText();




                Thread.sleep(2000);
                //till this point one employee has been added
                //verifying the employee is home-work
                click(dashboard.addEmployeeOption);
                Thread.sleep(2000);
            }

        }

    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel =
                ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);


        //it returns one map from list of maps
        Iterator<Map<String, String>> itr = empFromExcel.iterator();
        while (itr.hasNext()){
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();

            sendText(addEmployee.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployee.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployee.lastNameField, mapNewEmp.get("lastName"));

            sendText(addEmployee.photograph, mapNewEmp.get("photograph"));

            if(!addEmployee.checkBox.isSelected()){
                click(addEmployee.checkBox);
            }

            sendText(addEmployee.createusernameField, mapNewEmp.get("username"));
            sendText(addEmployee.createpasswordField, mapNewEmp.get("password"));
            sendText(addEmployee.confirmpasswordField, mapNewEmp.get("confirmPassword"));

            click(addEmployee.saveButton);

            //verification is in home-work
            Thread.sleep(2000);
            click(dashboard.addEmployeeOption);
            Thread.sleep(2000);
        }


    }



}


