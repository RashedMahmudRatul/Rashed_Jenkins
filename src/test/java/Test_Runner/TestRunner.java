package Test_Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = {"Step_Definition"},
        tags="@test",
        monochrome = true, dryRun = false,
        plugin = {"pretty","html:Reports/report.html"}
       )
//plugin = {"pretty","html:Reports/report.html"
//plugin = {"pretty","json:Reports/report2.json"
public class TestRunner {
}
