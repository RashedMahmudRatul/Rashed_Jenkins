package Utility;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Utility.Properties_Reader.browserName;

public class Driver_Setup {
    public static WebDriver driver;


    public static WebDriver setDriver() throws IOException {
//        if (driver==null){
            if (browserName().equals("Chrome")){
                System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
                System.out.println("Starting Chrome....");
                driver =new ChromeDriver();
            }
            else if(browserName().equals("Firefox")){
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                System.out.println("Starting Firefox....");
                driver = new FirefoxDriver();
            }
            else if(browserName().equals("Edge")){
                System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
                System.out.println("Starting Edge....");
                driver = new EdgeDriver();
            }
            else {

                System.out.println("No Such Browser available!!");
            }

//        }
//        else {
//            System.out.println("Deleted previous cookies!!!");
//            driver.manage().deleteAllCookies();
//
//        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }





}
