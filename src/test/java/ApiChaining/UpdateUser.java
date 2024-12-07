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

public class UpdateUser {
    @Test
    void updateUser(ITestContext context) {
        Faker faker = new Faker();
        JSONObject data = new JSONObject();
        data.put("name", faker.name().fullName());
        data.put("email", faker.internet().emailAddress());
        data.put("gender", "Female");
        data.put("status", "inactive");
        String BerearToken = "7578e937733f919835548d56d21dbf7b0110f708a5dddf0cdece06b2a5e0512b";
        int id = (Integer) context.getAttribute("user_id");
        given()
                .header("Authorization", "Bearer " + BerearToken)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(data.toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();

    }
}
