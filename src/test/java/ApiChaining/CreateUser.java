package ApiChaining;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateUser {
    @Test
    void createUser(ITestContext context) {

        //generating random data for test using faker
        Faker faker = new Faker();
        //String fullname = faker.name().fullName();
        //JSONObject obj = new JSONObject(); // generating data using json object
        //obj.put("name",faker.name().fullName());
        Map<String, String> mapData = new HashMap<>();
        mapData.put("name", faker.name().fullName());
        mapData.put("email", faker.internet().emailAddress());
        mapData.put("gender", "male");
        mapData.put("status", "active");

        String BerearToken = "7578e937733f919835548d56d21dbf7b0110f708a5dddf0cdece06b2a5e0512b";

        int id = given()
                .header("Authorization", "Bearer " + BerearToken)
                .contentType(ContentType.JSON)
                .body(mapData)
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath().getInt("id");

        context.setAttribute("user_id", id);
    }

}
