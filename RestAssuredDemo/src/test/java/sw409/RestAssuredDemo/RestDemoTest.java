package sw409.RestAssuredDemo;



import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class RestDemoTest {
	@Test
	void getUser() 
	{RestAssured.baseURI="https://gorest.co.in/public-api/users";
	RequestSpecification httprequest = RestAssured.given();
	Response response = httprequest.request(Method.GET, "/123");
	String res = response.getBody().asString();
	System.out.println("Response is" + res);
	int statusCode = response.statusCode();
	Assert.assertEquals(statusCode, 200);
	
	}
	@Test
void testAddCuster()
{
	RestAssured.baseURI=("http://dummy.restapiexample.com/api/v1");
	RequestSpecification httprequest = RestAssured.given();
	JSONObject reqparams = new JSONObject();
	reqparams.put("name", "btest");
	reqparams.put("salary", "3000");
	reqparams.put("age", "23");
	httprequest.header("Content-Type","application/json");
	httprequest.body(reqparams.toJSONString());
	Response httpresponse = httprequest.request(Method.POST, "/create");
	String res = httpresponse.getBody().asString();
	System.out.println("Response is " + res);
	int statuscode = httpresponse.statusCode();
	String statusMessage = httpresponse.jsonPath().get("status");
	Assert.assertEquals(statuscode, 200);
	Assert.assertEquals(statusMessage, "success");
}	

}
