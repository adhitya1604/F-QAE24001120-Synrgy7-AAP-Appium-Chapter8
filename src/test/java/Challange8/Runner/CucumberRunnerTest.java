package Challange8.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdef","hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-json.json"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
