import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Object[][] getData() {
        Object[][] data = {{"abc1@gmail.com", "abc"}, {"xyz1@gmail.com", "xyz"}, {"mno1@gmail.com", "mno"}};
        return data;

    }
}

