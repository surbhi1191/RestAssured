import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Day1RestassuredPractice {

 @Test
    void getUser()
 {
     given()
             .baseUri("https://reqres.in/")
             .when()
             .get("api/users?page=2")
             .then()
             .statusCode(200)
             .body("page",equalTo(2))
             .log().all();

 }


}
