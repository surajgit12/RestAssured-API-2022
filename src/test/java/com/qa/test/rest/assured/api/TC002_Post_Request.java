package com.qa.test.rest.assured.api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {
	
	
	@Test
     void createUserDetails() {
		

		// Specify Base URI  
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		// Request Payload sending along with Post Request
	
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("email", "eve.holt@reqres.in");
		requestparams.put("password", "pistol");
		
		httprequest.header("content-type","application/JSON"); // what kind of data it is , its an JSON format we need add header 
		
		
		httprequest.body(requestparams.toJSONString()); // it will add JSON body to the request or attached above data to request
		
		// Response Object
		Response response = httprequest.request(Method.POST,"register"); // path parameter
		
		// Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
	
		// Status Code Validation
		int statuscode = response.getStatusCode();
		if(statuscode==200) {
			System.out.println("Status Code  is :" +statuscode);
			Assert.assertEquals(statuscode, 200);
			responseBody = responseBody + "Success" +":"+ "true";
			System.out.println("Response Body is :" +responseBody);
		}
		
		
		// Success code message means which is printed in response body we need to verify :- its part of response body
		
		 int id_present_in_responseBody = response.jsonPath().get("id");   ///   "id": 4,  "token": "QpwL5tke4Pnpja7X4"
		 Assert.assertEquals(id_present_in_responseBody, 4);
		 
		 String token_present_in_responseBody= response.jsonPath().get("token");
		 Assert.assertEquals(token_present_in_responseBody, "QpwL5tke4Pnpja7X4");
		 
     }
	

}
