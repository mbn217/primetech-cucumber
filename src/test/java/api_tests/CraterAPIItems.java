package api_tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CraterAPIItems {

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
    public void create_an_Item(){
        Faker faker = new Faker();
        String endpoint ="api/v1/items";
        String itemName = faker.commerce().productName();
        String itemDescription = faker.commerce().material();
        String itemPrice = faker.commerce().price();
        System.out.println("The body of the request: " + itemName + " || " + itemDescription + " || " + itemPrice);
        System.out.println("Here is the token -->" + token);

        Map<String, Object> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);


        //We can use Maps for the requestBody
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", itemName);
        requestBody.put("price", itemPrice);
        requestBody.put("description", itemDescription);

        response = RestAssured.given()
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .post(baseUrl+endpoint);

        response.then().statusCode(200);
        response.prettyPrint();


    }


}
