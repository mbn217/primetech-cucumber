package api_tests;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CraterApiTestsInvoices {
    /**
     * Crater documentation: https://docs.crater.financial/#api-reference
     */
    String baseurl = "http://crater.primetech-apps.com/";
    Response response;
    String token;
    int item_id;
    List<Integer> invoiceIds = null;

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


        response = given()
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
    public void list_all_invoices() {

        String endpoint = "api/v1/invoices";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = given()
                .headers(requestHeaders)
                .when()
                .get(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");
        invoiceIds = response.jsonPath().getList("data.id");
        System.out.println(invoiceIds);
        //System.out.println(response.jsonPath().getString("data[0]"));





    }



    @Test(dependsOnMethods = "list_all_invoices")
    public void get_specific_invoice(){
        String endpoint = "api/v1/invoices/"+invoiceIds.get(0);
        System.out.println("We are deleting invoice with id: "+invoiceIds.get(0));

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("Accept", "application/json");
        requestHeaders.put("company", "1");
        requestHeaders.put("Authorization", "Bearer " + token);

        response = given()
                .headers(requestHeaders)
                .when()
                .get(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();
    }

//    @Test(dependsOnMethods = "list_all_invoices")
//    public void delete_an_Invoice(){
//        String endpoint = "api/v1/invoices/"+invoiceIds.get(0);
//        System.out.println("We are deleting invoice with id: "+invoiceIds.get(0));
//
//        Map<String, String> requestHeaders = new HashMap<>();
//        requestHeaders.put("Content-Type", "application/json");
//        requestHeaders.put("Accept", "application/json");
//        requestHeaders.put("company", "1");
//        requestHeaders.put("Authorization", "Bearer " + token);
//
//        response = given()
//                .headers(requestHeaders)
//                .when()
//                .delete(baseurl + endpoint);
//
//        response.then().statusCode(200).contentType("application/json");
//        response.prettyPrint();
//    }



//    @Test(dependsOnMethods = "delete_the_invoice")
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
