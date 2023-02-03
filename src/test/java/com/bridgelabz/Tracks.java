/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : Database Automation
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Tracks {
    public String auth;
    public String tid1;
    public String id;

    @BeforeTest
    public void setup() {
        auth = "Bearer BQCTS6-cLwPwe1zW5n848gCKoqO8UBNCGj6O4-eBnutjm5tv4dLXuVPkaXycicBsjI5ep8_" +
                "aFuFEJGovW7QpeLqCeEn8z6B55Z6ma49vfTLZdU7nhrtsO5NG6OGJD4Y59ro3Tw1fLIPl3UO6p_" +
                "LsWHcaZyZvjS9Z5zO2l9ddYSBvypn7KAiWffAdZeq7xr3eFLNG-oE9JOvxkRGExw5jEz1aTw7nD3-JUFObeREC-9SrBbUOVOHRmadap3nIzoA";
        tid1="7ouMYWpwJ422jRcDASZB7P";
        id="11dFghVXANMlKmJXsNCbNl";
    }

    @Test
    public void get_several_tracks(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/tracks?ids="+tid1);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }

    @Test
    public void get_Track(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/tracks/"+id);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }
}
