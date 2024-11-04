package GoogleMaps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPI_Addplace {

    // Validate Add place API is working as expected
    public static void main(String[] args) {

        // Principles of Rest Assured API
        // Given - All input details
        // When - Submit the API
        // Then - Validate the response

        RestAssured.baseURI="https://rahulshettyacademy.com";
        String bodys="{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Mano house\",\n" +
                "  \"phone_number\": \"(+91) 9080908090\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";

                //log().all() - used to capture the log, it can be used at given and then area.
        Response response = given().log().all().queryParam("key","qaclick123")
                .contentType(ContentType.JSON).body(bodys)
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .header("Server","Apache/2.4.52 (Ubuntu)")
                .body("scope",equalTo("APP")).extract().response();

        String res = response.asString();

        System.out.println("Place has been added successfully");

        // Update the place info after adding into the Map

        // To get the place id for update the place, we need to parse the json and extract it.
        JsonPath jsp = new JsonPath(res);
        String PlaceID = jsp.get("place_id");
        String Address1 = "70 JP Nagar 4th Phase, INDIA";
        System.out.println("PlaceID: "+PlaceID);

        // Update
                given().log().all().queryParam("key","qaclick123")
                .contentType(ContentType.JSON).body("{\n" +
                        "\"place_id\":\""+PlaceID+"\",\n" +
                        "\"address\":\""+Address1+"\",\n" +
                        "\"phone_number\": \"(+91) 9080908099\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().log().all().statusCode(200)
                .body("msg",equalTo("Address successfully updated"));

        // Get - Retrive the place info
        String getplaceres =  given().log().all().queryParam("key","qaclick123")
                .queryParam("place_id",PlaceID)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath jsp1 = new JsonPath(getplaceres);
        String Address2 = jsp1.getString("address");
        System.out.println(Address2);

        Assert.assertEquals(Address2,Address1);
    }
}
