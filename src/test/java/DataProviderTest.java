import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "loginDataProvider")
            public Object [][] getData()
    {
        Object [][]data = {{"abc@gmail.com","abc"},{"xyz@gmail.com","xyz"},{"mno@gmail.com","mno"}};
        return data;

    }
    @Test(dataProvider = "loginDataProvider",dataProviderClass = CustomDataProvider.class)
    public void loginTest(String email,String pwd)
    {
        System.out.println(email+" "+pwd);
    }
}
