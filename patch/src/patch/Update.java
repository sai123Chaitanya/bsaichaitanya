package patch;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class Update {
	
	@Test
	public void update()
	{
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		String post_repsonse = given().log().all().queryParam("Key", "qaclick123").body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Afsara Samreen\",\r\n"
				+ "  \"phone_number\": \"(+91) 898 893 1234\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").log().all().when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().asString();
		
		System.out.println("**************************************88");
		System.out.println(post_repsonse);
		
		
		
	}

}