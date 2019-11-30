package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement MyAccountLabel;

    public MyAccountPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }


}
