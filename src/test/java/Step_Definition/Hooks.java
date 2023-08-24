package Step_Definition;

import Utility.Driver_Setup;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver = Driver_Setup.driver;
    @After
    public void teardown() {
        System.out.println("In After Close>>>>");
        if (driver != null) {
            driver.quit();
        }
    }
}
