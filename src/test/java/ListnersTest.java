
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ListnersTest {
    @Test
    void test1()
    {
        System.out.println("this is test1");
        Assert.assertEquals("A","A");
    }
    @Test
    void test2()
    {
        System.out.println("this is test2");
        Assert.assertEquals("A","B");
    }
    @Test
    void test3()
    {
        System.out.println("test3");
        throw new SkipException("this is skip exception");
    }
}
