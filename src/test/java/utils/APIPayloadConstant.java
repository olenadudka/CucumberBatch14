package utils;

import APISteps.APIWorkFlowSteps;
import org.json.JSONObject;

public class APIPayloadConstant {
    public static String createEmployeePayload() {
        String createEmployeePayload =
                "{\n" +
                        "  \"emp_firstname\": \"olena\",\n" +
                        "  \"emp_lastname\": \"helen\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1988-01-14\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"QA engineer\"\n" +
                        "}";
        return createEmployeePayload;
    }

    public static String adminPayload() {
        String adminPayload =
                "{\n" +
                        "  \"email\": \"batch14@testolena.com\",\n" +
                        "  \"password\": \"Test123#\"\n" +
                        "}";
        return  adminPayload;

    }
        public static String createEmployeeJsonBody(){
            JSONObject obj=new JSONObject();
            obj.put("emp_firstname", "olena");
            obj.put("emp_lastname", "helen");
            obj.put("emp_middle_name", "ms");
            obj.put("emp_gender", "F");
            obj.put("emp_birthday", "1988-01-14");
            obj.put("emp_status", "confirmed");
            obj.put("emp_job_title","QA engineer");
            return obj.toString();


        }

    public static String createEmployeePayloadDynamic(String firstname, String lastname, String middlename,
                                                      String gender, String dob,
                                                      String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }
  public static String updateEmployeeJsonBody(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id", APIWorkFlowSteps.employee_id);
        obj.put("emp_firstname", "Julia");
        obj.put("emp_lastname", "Jonson");
        obj.put("emp_middle_name", "mrs");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2000-10-11");
        obj.put("emp_status", "good");
        obj.put("emp_job_title","Manager");
        return obj.toString();


}

   /* public static String updateEmployeePayLoadDaynamic(String empId,String firstname, String lastname, String middlename,
                                                       String gender, String dob,
                                                       String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("employee_id", APIWorkFlowSteps.employee_id);
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();

    }*/
}
