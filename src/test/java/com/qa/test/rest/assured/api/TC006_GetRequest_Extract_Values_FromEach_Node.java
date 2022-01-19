package com.qa.test.rest.assured.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GetRequest_Extract_Values_FromEach_Node {

	@Test
	void verifyAllFieldsinResponseBodyDetails() {
		
		// Specify Base URI
		RestAssured.baseURI = "https://reqres.in/api/users";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response response = httprequest.request(Method.GET, "/2");

		// Get a JsonPath view of the response body. This will let you use the JsonPath syntax to get values from the response.
		JsonPath jsonpath= response.jsonPath(); // it will give you complete response
		
		System.out.println(jsonpath.get("data.id")); // need to find proper JSON identifier
		System.out.println(jsonpath.get("data.email"));
		System.out.println(jsonpath.get("data.first_name"));
		System.out.println(jsonpath.get("data.last_name"));
		System.out.println(jsonpath.get("data.avatar"));
		System.out.println(jsonpath.get("support.url"));
		
		// Assert conditions
		Assert.assertEquals(jsonpath.get("data.id"), 2);
		Assert.assertEquals(jsonpath.get("data.email"), "janet.weaver@reqres.in");
		Assert.assertEquals(jsonpath.get("data.first_name"), "Janet");
		Assert.assertEquals(jsonpath.get("data.last_name"), "Weaver");
		Assert.assertEquals(jsonpath.get("data.avatar"), "https://reqres.in/img/faces/2-image.jpg");
	}
}
