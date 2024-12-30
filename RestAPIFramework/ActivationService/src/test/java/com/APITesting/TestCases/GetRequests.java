package com.APITesting.TestCases;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.*;

public class GetRequests {
	
	@Test
	public void Test_01() {
		
		String wetherDescription= given().
				       parameter("q", "London").
				       parameter("appid", "edd24e86dfacbde0252c2ba555218092").
				       when().
				       get("http://api.openweathermap.org/data/2.5/weather").
				       then().
				       contentType(ContentType.JSON).extract().
				       path("weather[0].description");
		
		System.out.println("Weather report :"+ wetherDescription);
		
	}

}
