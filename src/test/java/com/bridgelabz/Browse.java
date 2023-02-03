/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : Database Automation
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
public class Browse {
    public String auth;

    @BeforeTest
    public void setup() {
        auth = "Bearer BQCcapkZXDlacQNhEqlUr7nS9fTydanOLVLmfnlEhVYwRcfs8lzrgfKInMte398CGzcsD1mPWiYvcEQd_" +
                "eru3D9YohEu2ITqgFo3uqOOYAk7w9zb-VpGgblpaC73sVdtXejXFlSPDR4eMmr7SkmGyoXyAmi6S9_XAyIOtoMtAKYGZ-THQD-DrNx_" +
                "hy3hCsK5T4N3uTLxouIP6qwW8YXll1KYWiyYtboe5PoZ4grXVlXBiXXLrfzt0lGofR26HPWSeNWQDxLqkOWOmjHR";
    }

    @Test
    public void get_several_browsing_categories() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/browse/categories?country=IN&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }

    @Test
    public void get_new_release() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases?country=IN&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }
    @Test
    public void get_single_category() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner?country=IN");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
}
    @Test
    public void get_category_playlist() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists?country=IN&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
}
    @Test
    public void get_featured_playlist() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists?country=IN&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }
}