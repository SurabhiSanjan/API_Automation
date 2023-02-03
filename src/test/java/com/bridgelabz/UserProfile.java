/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : API Automation with restassured
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserProfile {
    public String auth;
    public String userId = "4e1daa087jlvs214o2w3gv8la";
    @BeforeTest
    public void setup(){
        auth ="Bearer BQDfVFEv19hgE22wnEL0dJpGk9EB_IC7kcCTi_igO95L60v4UtSEPRXKHwTFq3DNBJPDMPbAG2C0t19bBedmnPbWQJr_" +
                "ZsT3xErhqCX6dKu55vvH7zYISMcNmJ7bE_d7NDpUsFi_MD_U6Q87P1XXxCTAoyPjG0VthS8OXPVHTLKjSL5GV425OuqbuOmSz1983P-" +
                "KAQK_CAOvFV-XnGCtrF2ASHqfL9ihXlXovunz1VvI1-_qxe3oez19lPsMBpC5kssjajzIfqLqJS5Y0DYk4ZOhu7XT";
    }
    @Test
    public void getCurrentUserProfile(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/me");
        userId = response.path("id");
        System.out.println("userId : " +userId );
        String userName = response.path("display_name");
        System.out.println("user Name : " +userName );
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Assert.assertEquals("Surabhi sanjan", userName);
    }

    @Test
    public void getUserProfile(){
        Response response = given().contentType("application/json")
                .accept("application/json")
                .header("Authorization", auth)
                .when()
                .get("https://api.spotify.com/v1/users/4e1daa087jlvs214o2w3gv8la");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().log().all();
        response.then().statusCode(200).assertThat().body("display_name", equalTo("Surabhi sanjan"));
    }

    @Test
    public void getUserProfile_Successfully_ifStatusOk(){
        given().when().get("https://api.spotify.com/v1/me").then().log();
        given().when().get("https://api.spotify.com/v1/me").contentType();
        System.out.println(given().when().get("https://api.spotify.com/v1/me").timeIn(TimeUnit.MILLISECONDS));
    }

}