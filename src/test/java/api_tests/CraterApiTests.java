package api_tests;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CraterApiTests {
    /**
     * Crater documentation: https://docs.crater.financial/#api-reference
     */
    String baseurl = "http://crater.primetech-apps.com/";
    Response response;
    String token;
    int item_id;

    /**
     * An API Post request to login to the Crater app http://crater.primetech-apps.com/
     */
    @Test
    public void loginToCraterApp(){
        String endpoind = "api/v1/auth/login";
        String userEmail = "dummy@primetechschool.com";
        String userPassword = "primetech@school";

        //Option 1 we can use the body as a string in json format
        String payload = "{\n"
                + "    \"username\": \""+userEmail+"\",\n"
                + "    \"password\": \""+userPassword+"\",\n"
                + "    \"device_name\": \"mobile_app\"\n"
                + "}";


        response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .header("company", "1")
                .body(payload)
                .when()
                .post(baseurl+endpoind);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        //get the token from the response and store it in the token variable
        //We need the token so we can use it in the next requests
        token = response.jsonPath().getString("token");// or response.path("token");
        Assert.assertEquals(response.jsonPath().getString("type"), "Bearer");

        //----------------------------------------------

        //Option 2 we can use the body as a map
//        Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("username", userEmail);
//        requestBody.put("password", userPassword);
//        requestBody.put("device_name", "mobile_app");
//
//        //We Can also use header as a map
//        Map<String, Object> requestHeaders = new HashMap<>();
//        requestHeaders.put("Content-Type", "application/json");
//        requestHeaders.put("Accept", "application/json");
//        requestHeaders.put("company", "1");
//
//        response = RestAssured.given()
//                .headers(requestHeaders)
//                .body(requestBody)
//                .when()
//                .post(baseurl+endpoind);
//        response.then().statusCode(200).contentType("application/json");
//        response.prettyPrint();
//
//        // get the token from the response and assign it to token String
//        token = response.path("token");
//        Assert.assertEquals(response.path("type").toString(), "Bearer");


    }


    @Test(dependsOnMethods = "loginToCraterApp")
    public void create_an_item() {
        String endpoint = "api/v1/items";
        //We can use the Java Faker library to generate random data
        Faker faker = new Faker();
        String itemName = faker.commerce().productName();
        String itemDescription = faker.commerce().material();
        String itemPrice = faker.commerce().price();
        System.out.println("The body of the request: " + itemName + " || " + itemDescription + " || " + itemPrice); ;


        //We can use the body as a map
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", itemName);
        requestBody.put("description", itemDescription);
        requestBody.put("price", itemPrice);

        //We can also use the header as a map
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
//                .header("company", "1") // we can use this way or use map better way
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .post(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        item_id = response.path("data.id");
        System.out.println("Item ID: " + item_id);
    }



    @Test(dependsOnMethods = "create_an_item")
    public void update_the_item() {
        String endpoint = "api/v1/items/"+item_id;//we have to use the item id to update the item
        Faker faker = new Faker();
        String itemName = faker.commerce().productName();
        String itemDescription = faker.commerce().material();
        String itemPrice = faker.commerce().price();
        System.out.println("The body of the request: " + itemName + " || " + itemDescription + " || " + itemPrice);
        ;

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", itemName);
        requestBody.put("description", itemDescription);
        requestBody.put("price", itemPrice);

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = RestAssured.given()
                .headers(requestHeaders)
                .body(requestBody)
                .when()
                .put(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");

    }

    //This user might have permission to delete the item
    @Test(dependsOnMethods = "update_the_item")
    public void delete_the_item() {
        String endpoint = "api/v1/items/"+item_id;
        //Map<String, String> requestBody = new HashMap<>();

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = RestAssured.given()
                .headers(requestHeaders)
                //.body(requestBody) no request body needed because the id is in the endpoint
                .when()
                .delete(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");
        Assert.assertTrue(response.path("success"));

    }

//    @Test(dependsOnMethods = "delete_the_item")
//    public void logout() {
//        String endpoint = "api/v1/auth/logout";
//
//        Map<String, String> requestHeaders = new HashMap<>();
//        requestHeaders.put("Content-Type", "application/json");
//        requestHeaders.put("Accept", "application/json");
//        requestHeaders.put("company", "1");
//        requestHeaders.put("Authorization", "Bearer " + token);
//
//        response = RestAssured.given()
//                .headers(requestHeaders)
//                .when()
//                .post(baseurl + endpoint);
//
//        response.then().statusCode(200).contentType("application/json");
//
//    }


}
