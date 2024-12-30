package com.APITesting.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.APITesting.SetTestData.SetPostData;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class ActivateOrDeActivateItemsThroughINCOMM {
	
	@Test
	public void VerifyAssociateIsAbleToSuccessfullyActivateItemsThroughINCOMMCode()
	{
		SetPostData postData=new SetPostData();
		postData.setnodeId("");
		postData.setuserId("");
		postData.setfulfillOrdNbr("");
		postData.setupcNbr("");
		postData.setactivationType("");
		postData.setcode("");
		postData.setoldCode("");
		postData.setreturnType("");
		
		Response resp=given().
				      body(postData).
				      when().
				      contentType(ContentType.JSON).
				      post("http://HOST:PORT/fulfillment-node-dispensing-manager/resource/dispense/itemActivation");
		
		String responseCode=resp.path("");
		String responseStatus=resp.path("");
		
		Assert.assertEquals(responseCode, "200");
		Assert.assertEquals(responseStatus, "success");
	}

}
