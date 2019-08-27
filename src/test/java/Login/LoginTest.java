package Login;
import PageObjectImplementation.LoginModule.LoginPageActions;
import PageObjectImplementation.LogoutModule.LogoutPageActions;
import Utilities.TestInitialize;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestInitialize {
    LoginPageActions login = new LoginPageActions();
    LogoutPageActions logout = new LogoutPageActions();

    @BeforeClass
    public void reportConfiguration() {
        try{
        //UPDATE "suiteName" FOR EACH TEST SUITE
            String suiteName = "DSS-AUTOMATION";
            test = extent.createTest(suiteName);
            System.out.println("REPORT CONFIGURATION: PASSED");
        }catch (Exception e){
            System.out.println("***FAILED TO CONFIGURE REPORT");
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Test (priority = 1, testName = "User Login")
    public void TC001_userLoginSuccessfully() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            login.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");
        }
    }

//    @Test(priority = 16, testName = "User Logout")
//    public void TC100_userLogout() {
//        try{
//            System.out.println("USER LOGOUT: STARTED");
//            login.Logout();
//        }catch (Exception e){
//            Assert.fail("***USER LOGOUT: FAILED!");
//        }
//    }
    @Test (priority = 1, testName = "User Logout")
    public void TC002_userLogoutSuccessfully() {
        try{
            System.out.println("USER LOGOUT SUCCESSFULLY: STARTED");
            logout.logoutToCollections();
        }catch (Exception e){
            System.out.println("***USER LOGOUT SUCCESSFULLY: FAILED!");
        }
    }


    @AfterClass
    public void endTest() {
        //driver.manage().deleteAllCookies();
    }
//End Class
}