
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequests {
    int id; //initialize global variable

    @Test(priority = 1)
    void getUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    void createUser() {
        Map<String, Object> data = new HashMap();
        data.put("name", "san");
        data.put("job", "qa1");
        //JSONObject jsonObject = new JSONObject(data);
        id = given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

                /*.then()
                .statusCode(201)
                .log().all();*/
    }

    // updateuser
    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() throws FileNotFoundException {
        /*Map<String, Object> data = new HashMap();
        data.put("name", "sur");
        data.put("job", "engineer");*/
        //using json object

       /* JSONObject data = new JSONObject();
        data.put("name","sanjai");
        data.put("job","test");*/
        //using pojo- plain old java object
        PojoTest data =new PojoTest();
        data.setName("kamu");
        data.setJob("std");
        //using json body
        /*File f = new File(".\\body");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JsonObject data = new JsonObject();*/

        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("https://reqres.in/api/users" + "id")
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"createUser"})
    void deleteUser() {

        given()
                .when()
                .delete("https://reqres.in/api/users/" + "id")
                .then()
                .statusCode(204)
                .log().all();
    }


}
