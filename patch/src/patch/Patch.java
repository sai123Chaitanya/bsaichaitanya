package patch;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Patch {
	
	
	@Test
	public static void performpatch(){
		
		
		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		String patchrepsonse = given().header("Content-type","application/json").and().body("{\r\n"
				+ "\r\n"
				+ "    \"id\": \"290000000\"\r\n"
				+ "    \r\n"
				+ "}").when().patch("/posts/1").then().log().all().assertThat().statusCode(200).extract().asString();
		
		System.out.println("*********************************************");
		System.out.println(patchrepsonse);
		
	}
}

