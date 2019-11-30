package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndCorrectPasswordTest() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        loginPage.typeIntoUsernameField("a.maryniewski")
                .typeIntoPasswordField("aA123456")
                .clickOnSignInButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage,"Invalid email address.");
    }

    @Test
    public void asUserTryToLogInWithCorrectLoginAndIncorrectPasswordTest() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        loginPage.typeIntoUsernameField("a.maryniewski@gmail.com")
                .typeIntoPasswordField("aA1234567")
                .clickOnSignInButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage,"Authentication failed.");
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndIncorrectPasswordTest() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        loginPage.typeIntoUsernameField("a.maryniewski")
                .typeIntoPasswordField("aA1234567")
                .clickOnSignInButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage,"Invalid email address.");
    }

    @Test
    public void asUserTryToLogInWithNoLoginAndNoPasswordTest() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();

        loginPage.typeIntoUsernameField("")
                .typeIntoPasswordField("")
                .clickOnSignInButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage,"An email address required.");
    }

}
