package Pages;

import Utility.Driver_Setup;
//import Utility.Driver_Setup1;
import Utility.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Open_Cart_Page{
    public static WebDriver driver;
    WaitHelper waitHelper;
    private static final Logger logger = LogManager.getLogger(Open_Cart_Page.class);
    @FindBy(xpath = "//*[@id=\"input-email\"]")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"input-password\"]")
    WebElement pass;
    @FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div/form/input")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/h2[1]")
    WebElement loginAssertion;
    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    WebElement errorAssertion;


    public Open_Cart_Page(WebDriver driver) throws IOException {
        this.driver = Driver_Setup.driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver,this);
    }

    public void emailPassSend(){
        logger.info("Sening email pass");
        email.sendKeys("rashedmahmud689@gmail.com");
        waitHelper.waitForElement(email, Duration.ofSeconds(20));
        await("checking").atMost(20, SECONDS);
        pass.sendKeys("123456789");

        System.out.println("In Login page: "+driver);
    }
    public void emailPassSend(String email,String pass){
        this.email.sendKeys(email);
        this.pass.sendKeys(pass);

        System.out.println("In Login page: "+driver);
    }

    public void loginBtnClick(){
        loginBtn.click();
    }
    public String loginAssert(){

        return loginAssertion.getText();
    }
    public boolean loginAssertPositionCheck(){
        Point location = loginAssertion.getLocation();
        System.out.println(location);
        int xCoordinate = location.getX();
        int yCoordinate = location.getY();
        if (xCoordinate ==162 && yCoordinate == 356){
            return true;
        }
          return false;
    }


    public String errMsgAssert(){
        return errorAssertion.getText();
    }


}
