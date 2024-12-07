import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListnerTest implements ITestListener {
    public void onStart(ITestContext arg)
    {
        System.out.println("starts test execution.."+ arg.getName());
    }
    public void onFinish(ITestContext arg)
    {
        System.out.println("finish test execution"+arg.getName());
    }
public void onTestStart(ITestResult arg0)
{
    System.out.println("Starts test ..."+arg0.getName());
}
public void onTestSkipped(ITestResult arg0)
{
    System.out.println("skipped test.."+ arg0.getName());

}
    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("passed test.."+ arg0.getName());

    }
    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("failed test.."+ arg0.getName());

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        //

    }


}
