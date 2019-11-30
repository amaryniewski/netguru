package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@id='email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement submitLogin;

    @FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
    private WebElement messageLabel;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUsernameField(String username) {
        logger.info("Trying to type in username field.");
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed in username field.");
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        logger.info("Trying to type in password field.");
        passwordField.sendKeys(password);
        logger.info("Typed in password field.");
        return this;
    }

    public TopMenuPage clickOnSignInButton() {
        logger.info("Trying to click Sign In button");
        submitLogin.click();
        logger.info("Clicked Sign In button");
        return new TopMenuPage();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        return warningText;
    }
}