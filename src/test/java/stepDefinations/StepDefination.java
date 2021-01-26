package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	static String id;
	

@Given("Add Place Payload with {string}  {string} {string}")
public void add_Place_Payload_with(String userid, String body, String title) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	
//
		 res=given().spec(requestSpecification())
		.body(data.addPlacePayLoad(userid,body,title));
	}

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
//constructor will be called with value of resource which you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource()+ "api resource type");
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
//		else if(method.equalsIgnoreCase("UPDATE")){
//			response =res.when().put(resourceAPI.getResource());
//		}
		
}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),201);
		
	
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	  
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedBody, String resource) throws IOException {
	
	   // requestSpec
		id=getJsonPath(response,"id");
		 res=given().spec(requestSpecification()).queryParam("id",id);
		 user_calls_with_http_request(resource,"GET");
		  String actualBody=getJsonPath(response,"body");
		actualBody = actualBody.replaceAll("[\\[\\]\\(\\)]", "");
		  assertEquals(actualBody,expectedBody);
//		  Syste
		 
	    
	}
	

@Given("DeletePlace Payload")
public void deleteplace_Payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions
   
	res =given().spec(requestSpecification()).body(data.deletePlacePayload(id));
}




}
