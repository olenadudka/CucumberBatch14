package pages;

import io.cucumber.messages.internal.com.google.protobuf.Message;
import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id = "user_name")
    public WebElement createusernameField;

    @FindBy(id = "user_password")
    public WebElement createpasswordField;

    @FindBy(id = "re_password")
    public WebElement confirmpasswordField;




    public AddEmployeePage(){
        //page factory is the concept of selenium which we use to implement page
        //object model design patter which is responsible to initialize all the objects
        //of the class here when we say objects we mean locators what we also call object repository
        //if someone ask this to you in the interview you have to write the same thing



        PageFactory.initElements(driver, this);
    }


}
