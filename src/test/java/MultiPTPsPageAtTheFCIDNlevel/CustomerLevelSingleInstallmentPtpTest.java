package MultiPTPsPageAtTheFCIDNlevel;

import PageObjectImplementation.MultiPTPsModule.CustomerLevelSingleInstallmentPtpActions;
import PageObjectImplementation.LoginModule.LoginPageActions;
import PageObjectImplementation.LogoutModule.LogoutPageActions;
import Utilities.TestInitialize;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerLevelSingleInstallmentPtpTest extends TestInitialize {




        LoginPageActions login = new LoginPageActions();
        LogoutPageActions logout = new LogoutPageActions();
        CustomerLevelSingleInstallmentPtpActions installmentPtpTest = new CustomerLevelSingleInstallmentPtpActions();

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

        @Test(priority = 1, testName = "User Login")
        public void TC001_userLoginSuccessfully() {
            try{
                System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
                login.successfulLogin();
            }catch (Exception e){
                System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");

            }
        }

        @Test(priority = 2, testName = "Search Account")
        public void TC002_SingleInstallmentPtpTest() {
            try{
                System.out.println("USER SEARCH ACCOUNT: STARTED");
                installmentPtpTest.singleInstallmentPTP();
            }catch (Exception e){
                System.out.println("***USER SEARCH ACCOUNT: FAILED!");

            }
        }



  /*  @Test (priority = 3, testName = "User Logout")
    public void TC003_userLogoutSuccessfully() {
        try{
            System.out.println("USER LOGOUT SUCCESSFULLY: STARTED");
            logout.logoutToCollections();
        }catch (Exception e){
            System.out.println("***USER LOGOUT SUCCESSFULLY: FAILED!");
        }
    } */

        @AfterClass
        public void endTest() {
            driver.manage().deleteAllCookies();
        }
//End Class
    }

