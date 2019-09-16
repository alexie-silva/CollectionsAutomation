package PaymentArrangement;
import PageObjectImplementation.CollectionModule.CollectionPageActions;
import PageObjectImplementation.LoginModule.LoginPageActions;
import PageObjectImplementation.LogoutModule.LogoutPageActions;
import Utilities.TestInitialize;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentArrangement_AccountLevelTest extends TestInitialize {
    LoginPageActions login = new LoginPageActions();
    CollectionPageActions collection = new CollectionPageActions();
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

    @Test (priority = 1, testName = "User Log in")
    public void TC001_userLoginSuccessfully() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            login.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 2, testName = "User Account Search")
    public void TC002_searchAccount() {
        try {
            System.out.println("ACCOUNT SEARCHED SUCCESSFULLY: STARTED");
            collection.searchAccountActive();
        } catch (Exception e) {
            System.out.println("***ACCOUNT SEARCHED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 3, testName = "Create Disputes")
    public void TC003_createDisputes() {
        try {
            System.out.println("DISPUTE CREATED SUCCESSFULLY: STARTED");
            collection.disputes();
        } catch (Exception e) {
            System.out.println("***DISPUTE CREATED SUCCESSFULLY: FAILED!");
        }
    }

//    @Test(priority = 3, testName = "User Logout")
//    public void TC003_userLogoutSuccessfully () {
//        try {
//            System.out.println("USER LOGOUT SUCCESSFULLY: STARTED");
//            logout.logoutToCollections();
//        } catch (Exception e) {
//            System.out.println("***USER LOGOUT SUCCESSFULLY: FAILED!");
//        }
//    }

    @AfterClass
    public void endTest () {
        //driver.manage().deleteAllCookies();
    }
}
