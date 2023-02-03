/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : Database Automation
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
public class Artist {
    public String auth;
    public String id;
    public String id2;
    @BeforeTest
    public void setup() {
        auth = "Bearer BQD2WkQWtR4HiPp109Iq7-eUEch_3KpBdVYX6wcilNj742GqMWFKV_" +
                "lMP5Hp__BPbvwNtg-JdsNKEHYytLm6TeKv_F7JqXaZ6VcyE5sB7b-" +
                "UtFc9p0UqHPcEb9AspCy6R06BPn3AXTgmRGss5PP0oRgUW8luZ_" +
                "2FzC9Hj7__IrFwCdogXUv_IslsXiBkhnBF6C1_p4tbHnpcsNdJKIc5gcbMjhx-_" +
                "A51j1KBqlAVrV1Vd68wV8w-qgr2c2ZzenM";
        id="2CIMQHirSU0MQqyYHq0eOx";
        id2="57dN52uHvrHOxijzpIgu3E";
    }
    @Test
    public void get_several_artist() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/artists?ids="+id+id2);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }

    @Test
    public void get_artist() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/artists/"+id);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }

    @Test
    public void get_artist_top_tracks() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/artists/"+id+"/top-tracks?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }

    @Test
    public void get_artist_album() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/artists/"+id+"/albums?include_groups=single&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
    }
}
