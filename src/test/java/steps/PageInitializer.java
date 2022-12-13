package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dashboard;
    public static AddEmployeePage addEmployee;

    public static EmployeeListPage employeeList;

    public static void initializePageObjects(){
        login=new LoginPage(); //we create metod to initilize login objects to not call login page object in every method
      dashboard=new DashboardPage();
      addEmployee=new AddEmployeePage();
      employeeList=new EmployeeListPage();
    }
}
