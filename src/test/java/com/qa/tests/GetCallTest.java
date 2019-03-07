package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCallTest {

	@Test
	public void getCallTest() {
		// 1. specify the base url:
		RestAssured.baseURI = "https://reqres.in/api/users";

		// 2. Define a request:
		RequestSpecification httpRequest = RestAssured.given();
		// 3. Make a request with the parameter and http method:
		Response response = httpRequest.request(Method.GET, "/2");

		// 4. print the response as body: convert response to string:
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " + responseBody);

		// 5. get the status code:
		int statusCode = response.getStatusCode();
		System.out.println("the status code is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// 6. get all the headers:
		String contentType = response.header("Content-Type");
		System.out.println("the content type is: " + contentType);

	}
}
