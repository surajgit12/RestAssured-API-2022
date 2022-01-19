package com.qa.test.rest.assured.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_Get_Request {

	@Test
	void getUserDetails() {
		
		// Specify Base URI  
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		// Response Object
		Response response = httprequest.request(Method.GET,"/2"); // path parameter
		
		// Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
	
		// Status Code Validation
		int statuscode = response.getStatusCode();
		System.out.println("Status Code  is :" +statuscode);
		Assert.assertEquals(statuscode, 200);
		

		// Status line Validation
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is :" +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		

	}
}