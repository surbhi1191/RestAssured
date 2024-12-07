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
import org.testng.annotations.Test;

public class DeleteUser {
    @Test
    void deleteUser(ITestContext context)
    {
        int id = (Integer)context.getAttribute("user_id");
        String BerearToken = "7578e937733f919835548d56d21dbf7b0110f708a5dddf0cdece06b2a5e0512b";
        given()
                .header("Authorization","Bearer "+BerearToken)
                .pathParam("id",id)
                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(204)
                .log().all();
    }
}
