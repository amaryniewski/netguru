package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public MyAccountPage clickSignInButton() {
        WaitForElement.waitUntilElementIsClickable(signInButton);
        signInButton.click();
        logger.info("Clicked Sign In Button.");
        return new MyAccountPage();
    }

    public boolean isLogoutButtonDisplayed() {
        WaitForElement.waitUntilElementIsVisible(logoutButton);
        boolean logoutButtonDisplayed = logoutButton.isDisplayed();
        logger.info("Is logout button displayed: " + logoutButtonDisplayed);
        return logoutButtonDisplayed;

    }
}