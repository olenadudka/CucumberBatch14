package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.formula.functions.Today;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

//to change the order of execution we use fix method order since it is executing in order which is not good for us
//this method sortess will execute my methods in ascending /alphabeticl order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
    //one thing to remember
    //base URI - bae URL
    //end then using when keyword, we will send the end point
//we take base url from swagger than add http//
   String baseURI= RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";
   //we need to perform CRUD operations
   String token ="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQwODc4NzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDEzMTA3MiwidXNlcklkIjoiNDczNSJ9.EuXj3yOzSfMBDV0b3OtyoHXZla6u75dsAPg9TjU_xlY";
static String employee_id;
   @Test
   public void bgetOneEmployee(){
//prepare request
      //to prepare the rrquest, we use request specification
      RequestSpecification request= given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", employee_id);
      //to hit the end point/to make the request which will return response
     Response response= request.when().get("/getOneEmployee.php");
   //   System.out.println(response.asString());
       response.prettyPrint();
      //verifying the status code
      response.then().assertThat().statusCode(200);

      //using jsonpath method we are extracting the value from response body
    String firstName=  response.jsonPath().getString("employee.emp_firstname");
       System.out.println(firstName);

       //first way of assertion
       Assert.assertEquals(firstName, "olena");

       //second way of assertion to verify the value in response body using hamcrest matchers
       response.then().assertThat().body("employee.emp_firstname", equalTo("olena"));
   }
@Test
   public void acreateEmployee(){
       RequestSpecification request= given().header("Authorization", token).header("Content-Type", "application/json").
               body("{\n" +
                       "  \"emp_firstname\": \"olena\",\n" +
                       "  \"emp_lastname\": \"helen\",\n" +
                       "  \"emp_middle_name\": \"ms\",\n" +
                       "  \"emp_gender\": \"F\",\n" +
                       "  \"emp_birthday\": \"1988-01-14\",\n" +
                       "  \"emp_status\": \"confirmed\",\n" +
                       "  \"emp_job_title\": \"QA engeneer\"\n" +
                       "}");
       Response response = request.when().post("/createEmployee.php");
       response.prettyPrint();
       //verfying the statuys code which is 201
       response.then().assertThat().statusCode(201);
       //getting the employee id from the response and use it as static one
       employee_id = response.jsonPath().getString("Employee.employee_id");
    System.out.println(employee_id);
    response.then().assertThat().body("Employee.emp_lastname", equalTo("helen"));
    response.then().assertThat().body("Employee.emp_middle_name", equalTo("ms"));
    //verify console header
    response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

   }

   @Test
public void cupdateEmployee(){
    RequestSpecification request= given().header("Authorization", token).header("Content-Type", "application/json").
            body("{\n" +
                    "  \"employee_id\": \""+ employee_id +"\",\n" +
                    "  \"emp_firstname\": \"Pamela\",\n" +
                    "  \"emp_lastname\": \"Green\",\n" +
                    "  \"emp_middle_name\": \"ms\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"2001-01-15\",\n" +
                    "  \"emp_status\": \"activ\",\n" +
                    "  \"emp_job_title\": \"manager\"\n" +
                    "}");

    Response response = request.when().put("/updateEmployee.php");

    //verification
    response.then().assertThat().statusCode(200);
    response.then().assertThat().body("Message", equalTo("Employee record Updated"));
}
@Test

public void dgetUpdatedEmployee(){
    RequestSpecification request = given().header("Authorization", token)
            .header("Content-Type", "application/json")
            .queryParam("employee_id", employee_id);

    //to hit the end point/ to make the request which will return response
    Response response = request.when().get("/getOneEmployee.php");

    // System.out.println(response.asString());
    response.prettyPrint();
    //verifying the status code
    response.then().assertThat().statusCode(200);
    response.then().assertThat().body("employee.emp_job_title", equalTo("Manager"));
}

}
