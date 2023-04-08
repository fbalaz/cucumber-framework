package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions (
        features = "src/test/java/features/KroneDemo.feature",
        glue = {"steps", "hooks"},
        monochrome = true,
        plugin={"pretty","html:target/cucumber-reports/report.html","json:target/cucumber-reports/report.json",
                "testng:target/cucumber-reports/report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}





)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
