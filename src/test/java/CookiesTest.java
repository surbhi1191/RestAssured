import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesTest {
   // @Test(priority = 1)
    public void testCookies()
    {
      given()
              .when()
              .get("https://www.google.com/")
              .then()
              .log().cookies();

    }
    @Test(priority = 2)
    public void getCookiesInfo() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
                //.then()
               // .log().cookies();
        //get single cookies info
        //System.out.println(res.getCookie("AEC"));
        //get all cookies info
        Map <String,String> cookies_val = res.getCookies();
        for (Map.Entry<String,String> e:cookies_val.entrySet())
        {
            System.out.println(e.getKey()+": "+ e.getValue());

        }
    }
}
