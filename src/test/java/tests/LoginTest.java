package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationBarPage;

import static filesReadersManager.ReadFromFiles.getPropertyByKey;

public class LoginTest extends BaseTest_Parent {
    @Test
    public void TestLoginToApp()
    {
        NavigationBarPage navigationBarPage=new NavigationBarPage(driver);
        LoginPage loginPage = navigationBarPage.clickLoginFromNavigationBar();
        HomePage homePage = loginPage.
                loginToAppWithValidCredentials
                        (
                        getPropertyByKey(configPropertyFileName, "EMAIL"),
                       getPropertyByKey(configPropertyFileName, "PASSWORD")
                        );
        Assert.assertEquals(homePage.getWelcomeMsg(), "WELCOME TO OUR STORE");
    }
}
