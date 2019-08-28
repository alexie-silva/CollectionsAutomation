package PageObjectImplementation.LoginModule;
import PageObject.LoginPage.LoginPage;
import org.junit.Assert;

public class LoginPageActions extends LoginPage {

    public void successfulLogin() {
            waitFor(5);
            /*try {
                org.testng.Assert.assertTrue(isElementDisplayed(txtContinue));
                click(txtContinue);
            } catch (Exception e) {
                waitFor(5);
            }*/
            try {
                waitElementToBeEnabled(txtbxUsername, 10);
                String user =  readXml("username");
                String pass = readXml("password");

                type(txtbxUsername, user);
                type(txtbxPassword, pass);
             //   waitFor(5);
                click(btnLogin);

                switchFrame(frmHeader);
                Thread.sleep(3000);
                Assert.assertTrue(isElementDisplayed(lblDashboard));
                System.out.println("USER LOGIN SUCCESSFULLY: PASSED");
            } catch (Exception e) {
                System.out.println("***FAILED TO LOGIN USING " + readXml("username") + " USERNAME");
                System.exit(1);
            }
        }

    public void Logout(){
        try {
            Assert.assertTrue("Login text is not Displayed", isElementDisplayed("loginText"));
        }catch (Exception e){
            System.out.println("***USER LOGOUT ACTION PAGE: FAILED"); }
    }

//END OF TEST//
}