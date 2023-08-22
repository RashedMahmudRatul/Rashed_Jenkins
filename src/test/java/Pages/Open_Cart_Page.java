package Pages;

import Utility.Driver_Setup;
//import Utility.Driver_Setup1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Open_Cart_Page{
    public static WebDriver driver;
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

    public Open_Cart_Page(){

    }
    public Open_Cart_Page(WebDriver driver) throws IOException {
//        this.driver = Driver_Setup.driver;
        PageFactory.initElements(driver,this);
    }

    public void emailPassSend(){
        email.sendKeys("rashedmahmud689@gmail.com");
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

    public String errMsgAssert(){
        return errorAssertion.getText();
    }


}
