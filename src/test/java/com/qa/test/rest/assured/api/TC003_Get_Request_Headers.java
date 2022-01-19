package com.qa.test.rest.assured.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Get_Request_Headers {
	
	
	@Test
	void getheadersDetails() {
		
		
		        // Specify Base URI  
				RestAssured.baseURI="https://reqres.in/api/users";
				
				//Request Object
				RequestSpecification httprequest = RestAssured.given();
				
				// Response Object
				Response response = httprequest.request(Method.GET,"/2"); // path parameter
				
				// Print response in console
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is :" +responseBody);
			
			   // captures details of headers from response
				
				String contenttype = response.header("content-type");
				System.out.println("Content-type  is :" +contenttype);
				Assert.assertEquals(contenttype, "application/json; charset=utf-8");
		
	}

}
