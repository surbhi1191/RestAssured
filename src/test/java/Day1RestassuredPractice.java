import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Day1RestassuredPractice {
int id ;
 @Test(priority = 1)
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
 @Test(priority = 2)
 void createUser()
 {
     Map<String,String> data = new HashMap<>();
     data.put("name","sur");
     data.put("job","engineer");
     id =given()
             .contentType(ContentType.JSON)
             .body(data)
             .when()
             .post("https://reqres.in/api/users")
             .jsonPath().getInt("id");

 }
    @Test(priority = 3)
    void UpdateUser()
    {
        Map<String,String> data = new HashMap<>();
        data.put("name","sanjai");
        data.put("job","qa");
        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put("https://reqres.in/api/users/id")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 4)
    void deleteUser()
    {
        given()
                .when()
                .delete("https://reqres.in/api/users/id")
                .then()
                .statusCode(204);

    }

}
