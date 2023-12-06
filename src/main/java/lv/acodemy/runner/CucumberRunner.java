package lv.acodemy.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lv.acodemy.utils.LocalDriverManager;
import org.testng.annotations.AfterMethod;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"lv.acodemy.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

    @AfterMethod()
    public static void afterTest() {
        LocalDriverManager.closeDriver();
    }
}
