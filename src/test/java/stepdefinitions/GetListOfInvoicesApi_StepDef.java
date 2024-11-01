package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetListOfInvoicesApi_StepDef {
    String baseurl = "http://crater.primetech-apps.com/";
    Response response;
    String token;

    @Given("I'm logged in successfully")
    public void i_m_logged_in_successfully() {
        String endpoind = "api/v1/auth/login";
        String userEmail = "dummy@primetechschool.com";
        String userPassword = "primetech@school";
//
//        String payload = "{\n"
//                + "    \"username\": \""+userEmail+"\",\n"
//                + "    \"password\": \""+userPassword+"\",\n"
//                + "    \"device_name\": \"mobile_app\"\n"
//                + "}";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", userEmail);
        requestBody.put("password", userPassword);
        requestBody.put("device_name", "mobile_app");


        response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("company", "1")
                .body(requestBody)
                .when()
                .post(baseurl+endpoind);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        //get the token from the response and store it in the token variable
        //We need the token so we can use it in the next requests
        token = response.jsonPath().getString("token");// or response.path("token");


    }
    @When("I perform GET operation for {string} endpoint")
    public void i_perform_get_operation_for_endpoint(String endpoint) {
        response = given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseurl + endpoint);




    }
    @Then("I should get {int} status code")
    public void i_should_get_status_code(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }
    @And("I should get list of invoices")
    public void i_should_get_list_of_invoices() {
        response.prettyPrint();
    }


}
