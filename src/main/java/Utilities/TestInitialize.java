package Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestInitialize extends Action{

    public ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(currentDirectory.toString().concat("\\test-output\\extentReport.html"));
    public ExtentReports extent = new ExtentReports();
    public ExtentTest test;

    @BeforeClass
    public void testInitialize() {
        try {
            System.out.println("TEST INITIALIZE: STARTED");
            openBrowser(readXml("browser"));
            navigateURL(readXml("url"));
            maximizeBrowser();
            extent.attachReporter(htmlReporter);
            System.out.println("TEST INITIALIZE: PASSED");
        } catch (Exception e) {
            System.out.println("***TEST INITIALIZE: FAILED");
            return; }
    }

    @AfterClass()
    public void sendEmailReport(){
        try{
            driver.close();
            driver.quit();
            sendTestReport();
            System.out.println("END TEST: PASSED");
        } catch (Exception e){
            System.out.println("***END TEST: FAILED"); }
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        } extent.flush();
    }

    @AfterSuite
    public void tearDown(){
        extent.removeTest(test);
    }
//END OF TESTINITIALIZE
}
