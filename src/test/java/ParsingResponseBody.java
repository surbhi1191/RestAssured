import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingResponseBody {
    //@Test(priority = 1)
    public void testJsonResponse() {
        //Approach1 validate in then but we can't use loops there
       /*given()
               .contentType(ContentType.JSON)
               .when()
               .get("https://reqres.in/api/users?page=2")
               .then()
               .header("Content-Type","application/json; charset=utf-8")
               .body("data[0].last_name",equalTo("Lawson"))
               .body("data[0].first_name",equalTo("Michael"))
               .body("page",equalTo(2));*/
        //aproach2

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
        String lastname = res.jsonPath().get("data[0].last_name").toString();
        Assert.assertEquals(lastname, "Lawson");
    }

    @Test(priority = 2)
    public void testJsonResponseBody() {

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");
        JSONObject jo = new JSONObject(res.asString());
        boolean status = false;
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String lastname = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
            if (lastname.equals("Ferguson")) {
                status = true;
                break;
            }


        }
        Assert.assertEquals(status, true);

    }
}
