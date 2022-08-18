package com.api.demo;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demorestassured {

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

        new Demorestassured().postCallVerify();

    }

    public void getCallVerify() throws JsonMappingException, JsonProcessingException {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Books";

        // Get call
        String responseString = given().log().all().when().get("/2").then().assertThat().statusCode(200).extract().response().asString();

//		System.out.println(responseString);

        // post call
//		String requestBody = "{\r\n"
//				+ "  \"id\": 0,\r\n"
//				+ "  \"title\": \"string\",\r\n"
//				+ "  \"description\": \"string\",\r\n"
//				+ "  \"pageCount\": 0,\r\n"
//				+ "  \"excerpt\": \"string\",\r\n"
//				+ "  \"publishDate\": \"2022-08-08T17:35:28.367Z\"\r\n"
//				+ "}";

//		given().log().all().contentType("application/json")
//		.body(requestBody).
//		when().post()
//		.then().assertThat().statusCode(200);

        // put call

//		given().log().all().contentType("application/json")
//		.body(requestBody).
//		when().put("/2")
//		.then().assertThat().statusCode(200);

        // delete call
//		given().log().all().
//		when().delete("/2")
//		.then().assertThat().statusCode(200);

    }

    public void postCallVerify() {

        RestAssured.baseURI = "https://api.odfl.com";

        String str = "{\"originPostalCode\":\"95106\",\"destinationPostalCode\":\"11230\",\"originCity\":\"SAN JOSE\",\"destinationCity\":\"BROOKLYN\",\"pickupDate\":\"2022-08-19\"}";

        Response response = given()
                .config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Accept")))
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(str)
                .when()
                .post("/transit-time/search/v1.0/transit-time.info");

        response.then().assertThat().statusCode(200);

    }

}
