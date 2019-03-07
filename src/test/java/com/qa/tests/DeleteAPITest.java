package com.qa.tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DeleteAPITest {
	
	@Test
	public void deleteAPITest() {

		// 1. specify the base url:
		RestAssured.baseURI = "https://reqres.in/api/users";

		// 2. Define a request:
		RequestSpecification httpRequest = RestAssured.given();
		// 3. Make a request with the parameter and http method:
		Response response = httpRequest.request(Method.DELETE, "/5");

		// 4. print the response as body: convert response to string:
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// 5. get the status code:
		int statusCode = response.getStatusCode();
		System.out.println("the status code is: " + statusCode);
		Assert.assertEquals(statusCode, 204);

	}
	

}
