import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class HeadersDemo {

   // @Test(priority = 1)
    public void hearderstest()
    {
        given()
                .when()
                .get("https://www.google.com/")
                .then();
    }

  //  @Test(priority = 2)
    public void getHearders()
    {
       Response res = given()
                .when()
                .get("https://www.google.com/");
        System.out.println( res.getHeader("Content-Type"));
    }



}
