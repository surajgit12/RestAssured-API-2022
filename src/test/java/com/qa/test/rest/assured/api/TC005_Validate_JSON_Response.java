package com.qa.test.rest.assured.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_Validate_JSON_Response {

	@Test
	void validateJSONResponseDetails() {

		// Specify Base URI
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response response = httprequest.request(Method.GET, "/2");

		// Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" + responseBody);
		
		Assert.assertEquals(responseBody.contains("Janet"), true);
		Assert.assertEquals(responseBody.contains("To keep ReqRes free, contributions towards server costs are appreciated!"), true);
	}

}
