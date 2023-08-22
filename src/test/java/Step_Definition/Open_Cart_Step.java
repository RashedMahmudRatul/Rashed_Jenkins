package Step_Definition;

import Pages.Open_Cart_Page;

import Utility.Driver_Setup;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class Open_Cart_Step  {
    public WebDriver driver;
    private Scenario scenario;
    Open_Cart_Page lp;

    public Open_Cart_Step() throws IOException {
        this.driver = Driver_Setup.setDriver();
        lp = new Open_Cart_Page(driver);
    }


//    @Before
//    public void before(Scenario scenario) {
//        this.scenario = scenario;
//    }
//
//    @After
//    public void close(){
//       driver.close();
//    }

    @Given("I am on opencart login page")
    public void i_am_on_opencart_login_page() throws IOException {
        System.out.println("In login Step: "+driver);
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @When("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() throws IOException, InterruptedException {
        lp.emailPassSend();
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        lp.loginBtnClick();

    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals("My Account",lp.loginAssert());
    }



    @When("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String string, String string2) throws InterruptedException {
        System.out.println("sdfsdfdsf");
        lp.emailPassSend( string, string2);

    }

    @Then("i should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String string) throws InterruptedException {
        System.out.println(string);
        System.out.println(lp.errMsgAssert());
        Assert.assertEquals(string,lp.errMsgAssert());



    }
}
