package patch;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

public class Patch {

	public static void main(String[] args) {
		
		
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
<<<<<<< HEAD
//major edit 345 456 562
=======
//major edit 5678
>>>>>>> 24bee235a30ee7acb3c42fc7f39767483673346e
//hello world
//edit 35
//eidt36
//edit3876
//edit1
//edit2
//eidt3
//edit2
