package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetListOfInvoicesAPI_StepDef {
    String baseUrl = "http://crater.primetech-apps.com/";
    Response response;
    String token;
    @Given("Im logged in successfully")
    public void im_logged_in_successfully() {
        String endpoint ="api/v1/auth/login";
        String userEmail ="dummy@primetechschool.com";
        String userPassword = "primetech@school";

        //We Can also use header as a map
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");

        //We can use Maps for the requestBody
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", userEmail);
        requestBody.put("password", userPassword);
        requestBody.put("device_name", "mobile_app");


        response = RestAssured.given()
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .post(baseUrl+endpoint);
        token = response.path("token");
    }
    @When("I perform GET operation for {string} endpoint")
    public void i_perform_get_operation_for_endpoint(String endpoint) {
        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);
        response = RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseUrl+endpoint);

    }
    @Then("I should get {int} status code")
    public void i_should_get_status_code(Integer int1) {
        response.then().statusCode(200);
    }
    @And("I should get list of invoices")
    public void i_should_get_list_of_invoices() {
        List<String> listOfIds = response.jsonPath().getList("data.id");
        List<String> listOfIdsUsingPath = response.path("data.id");
        System.out.println("Using path " + listOfIdsUsingPath);
        System.out.println("Using jsonPath " + listOfIds);
        Assert.assertTrue(!listOfIds.isEmpty());
    }


}
