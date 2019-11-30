package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithCorrectLoginAndPasswordTest() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        boolean isUserLogged = loginPage.typeIntoUsernameField("a.maryniewski@gmail.com")
                .typeIntoPasswordField("aA123456")
                .clickOnSignInButton()
                .isLogoutButtonDisplayed();

        assertTrue(isUserLogged);
    }
}
