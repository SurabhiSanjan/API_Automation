/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : Database Automation
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;

public class Playlist {
    public String auth;
    public String pid1;
    public String tr1;
    public String userId;

    @BeforeTest
    public void setup() {
        auth = "Bearer BQDfVFEv19hgE22wnEL0dJpGk9EB_IC7kcCTi_igO95L60v4UtSEPRXKHwTFq3DNBJPDMPbAG2C0t19bBedmnPbWQJr_" +
                "ZsT3xErhqCX6dKu55vvH7zYISMcNmJ7bE_d7NDpUsFi_MD_U6Q87P1XXxCTAoyPjG0VthS8OXPVHTLKjSL5GV425OuqbuOmSz1983P-" +
                "KAQK_CAOvFV-XnGCtrF2ASHqfL9ihXlXovunz1VvI1-_qxe3oez19lPsMBpC5kssjajzIfqLqJS5Y0DYk4ZOhu7XT";
        pid1 = "5tb0k61FoxxGgyQT5IuXVk";
        tr1 = "2takcwOaAZWiXQijPHIx7B";
        userId = "4e1daa087jlvs214o2w3gv8la";
    }

    @Test
    public void createPlaylist() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "New Playlist21");
        requestBody.put("description", "New Playlist21 description");
        requestBody.put("public", "false");
        Response response = given().contentType(ContentType.JSON)
                .accept("application/json")
                .header("Authorization", auth)
                .body(requestBody.toJSONString())
                .when()
                .post("https://api.spotify.com/v1/users/" + userId + "/playlists");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }

    @Test
    public void addItemsToPlaylist() {
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .post("https://api.spotify.com/v1/playlists/" + pid1 + "/tracks?uris=spotify:track:" + tr1);
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }

    @Test
    public void remove_playlist() {
        Response response = given().contentType(ContentType.JSON)
                .accept("application/json")
                .header("Authorization", auth)
                .body("{\"tracks\": [{ \"uri\": \"spotify:track:2takcwOaAZWiXQijPHIx7B\" }]}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/"+pid1+"/tracks");
        response.prettyPrint();
    }

    @Test
    public void getPlaylistItems(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/playlists/"+pid1+"/tracks");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();

    }
}