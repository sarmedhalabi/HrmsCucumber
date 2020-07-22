package com.hrms.Apipractice;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class getData {
	@Ignore
	@Test
	public void testResponse() {
		Response res= get("https://reqres.in/api/users?page=2");
		int code= res.getStatusCode();
		System.out.println(("system code is "+ code));
		Assert.assertEquals(code,200);
		
		
	}
	@Ignore
	@Test
	public void testBody() {
		Response res= get("https://reqres.in/api/users?page=2");
		String data= res.asString();
		System.out.println("body response is "+data);
	}
	@Test
	public void anotherWay() {
		int code= get("https://reqres.in/api/users?page=2").getStatusCode();
		String bodyData= get("https://reqres.in/api/users?page=2").asString();
		long time= get("https://reqres.in/api/users?page=2").getTime();
		System.out.println(code+" "+bodyData+" "+time);
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.id[0]",equalTo(7)).body("data.first_name", hasItems("Tobias"),("George")).log().all();
		
		
		
	}

}
