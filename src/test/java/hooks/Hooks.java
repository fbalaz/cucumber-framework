package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.GenericUtils;
import utilities.TestContextSetup;

import java.util.Properties;

public class Hooks {

    private TestContextSetup testContextSetup;
    private GenericUtils genericUtils;
    private Properties prop;


    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.genericUtils = testContextSetup.genericUtils;
        this.prop = genericUtils.getProp();

    }


    @Before
    public void setUp() {
        genericUtils.chooseBrowser();
        Configuration.baseUrl = prop.getProperty("base_url");
        //ChromeOptions opt = new ChromeOptions();
        //Configuration.browserCapabilities = opt.addArguments("--incognito");

    }

    @AfterStep
    public void getScreenshotOnFailure(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach(genericUtils.takeScreenshot(), "image/png","failedStepScreenshot");
        }
    }
}
