package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CraterAPIInvoices {

    String baseUrl = "http://crater.primetech-apps.com/";
    Response response;
    String token;

    @Test
    public void loginToCraterApp(){
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

        response.then().statusCode(200);
        response.prettyPrint();
        token = response.path("token");
        System.out.println(token);

    }

    @Test(dependsOnMethods = "loginToCraterApp")
    public void get_all_Invoices(){
        String endpoint = "api/v1/invoices";

        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = RestAssured.given()
                .headers(requestHeaders)
                .when()
                .get(baseUrl+endpoint);

        response.then().statusCode(200);
        response.prettyPrint();




    }

}
