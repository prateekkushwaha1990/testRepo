package com.api.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Demorestassured {

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

        new Demorestassured().getCallVerify();

    }

    public void getCallVerify() throws JsonMappingException, JsonProcessingException {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Books";

        String responseString = given().log().all().when().get("/2").then().assertThat().statusCode(200).extract().response().asString();




    }
}
