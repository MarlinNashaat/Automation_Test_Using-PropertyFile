package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.RegistrationPage;
import pages.SuccessfulRegistrationPage;

import static filesReadersManager.ReadFromFiles.getJsonValueByKey;


public class RegistrationTest extends BaseTest_Parent {
    String fname;
    String lname;
    String email;
    String password;
    String confirmPassword;

    @BeforeClass
    public void loadTestData() {
        String testDataJsonFile = "registrationTestData.json" ;
        fname = (String) getJsonValueByKey(testDataJsonFile, "fnameKey");
        lname = (String) getJsonValueByKey(testDataJsonFile, "lnameKey");
        email = (String) getJsonValueByKey(testDataJsonFile, "emailKey");
        email = email.format(email, System.currentTimeMillis());
        password = (String) getJsonValueByKey(testDataJsonFile, "passwordKey");
        confirmPassword = (String) getJsonValueByKey(testDataJsonFile, "confirmPasswordKey");
    }

    @Test(priority = 1)
    public void testRegisterNewUser() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        RegistrationPage registrationPage = navigationBarPage.clickRegisterFromNavigationBar();
        SuccessfulRegistrationPage successfulRegistrationPage =
                registrationPage.registerNewUser(fname,lname,email,password,confirmPassword);
        Assert.assertEquals(successfulRegistrationPage.getSuccessfulRegistrationMsg(),
                "Your registration completed", "error registration message");
    }

}
