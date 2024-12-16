import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class RestAssuredDay2Practice {
    // ways to create payload for post request
    // 1. using hashmap
    // 2. using Json object
    // 3. using pojo class
    // 4. using external json file
    int id;

    @Test
    void createUserUsingHashmap() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "surbhi");
        data.put("job", "qa");
        id = given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
           /* .then()
            .body("name",equalTo("surbhi"))
            .body("job",equalTo("qa"))
            .header("Content-Type","application/json; charset=utf-8")
            .log().all();*/
    }

    @Test
    void deleteUser() {
        given()

                .when()
                .delete("    https://reqres.in/api/users/id")
                .then()
                .statusCode(204);

    }

    @Test
    void createUserUsingJsonobject() {
        JSONObject data = new JSONObject();
        data.put("name", "sam");
        data.put("job", "dev");
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())  // needs to convet data into string format
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("sam"))
                .body("job", equalTo("dev"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test
    void createUserUsingPojoClass() {
      PojoDay2 data = new PojoDay2();
      data.setName("kom");
      data.setJob("engineer");
      given()
              .contentType(ContentType.JSON)
              .body(data)
              .when()
              .post("https://reqres.in/api/users")
              .then()
              .statusCode(201)
              .body("name",equalTo("kom"))
              .body("job",equalTo("engineer"))
              .log().all();
    }
}
