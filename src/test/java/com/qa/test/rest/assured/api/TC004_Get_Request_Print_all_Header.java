package com.qa.test.rest.assured.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Get_Request_Print_all_Header {
	
	
	@Test
	void getAllHeaders() {
		
		// Specify Base URI  
		RestAssured.baseURI ="https://reqres.in/api/users";
		
		// Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		// Response Object
		Response response = httprequest.request(Method.GET,"/2");
		
		// Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		// Captures all headers from response
		Headers all_headers =response.headers(); 
		
		for(Header header:all_headers) {
			
			/*
			 * System.out.println(header.getName()); System.out.println(header.getValue());
			 */
			
			System.out.println(header.getName() +  "--------->" +  header.getValue());
		}
		
		
	}
	
	
	
	
	
	

}
