package com.qa.test.rest.assured.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Authentication_API {
	
	@Test
	void authorizationTest() {
		
		
		       // Specify Base URI  
				RestAssured.baseURI="http://api.github.com/user/repos";
				
				// Basic Authentication
				
				
				  PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
				  
				  authscheme.setUserName("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");
				  authscheme.setPassword("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");
				  
				  RestAssured.authentication = authscheme;
				 
				 
				
				//Request Object
				RequestSpecification httprequest = RestAssured.given();
				
				// Response Object
				Response response = httprequest.request(Method.GET,""); // path parameter
				
		
				// Print response in console
				String responseBody = response.getBody().asString();
				System.out.println("Response Body is :" +responseBody);
			
				// Status Code Validation
				int statuscode = response.getStatusCode();
				System.out.println("Status Code  is :" +statuscode);
				Assert.assertEquals(statuscode, 200);
				
		
	}

}
