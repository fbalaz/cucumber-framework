package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.AutomationPracticePage;
import utilities.TestContextSetup;

import java.util.ArrayList;
import java.util.Set;

import static com.codeborne.selenide.Selenide.switchTo;

public class AutomationPracticeStepDefinition {

    private TestContextSetup testContextSetup;
    private AutomationPracticePage automationPracticePage;
    private ArrayList<String> tabTitles;

    public AutomationPracticeStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.automationPracticePage = testContextSetup.pageObjectManager.getAutomationPracticePage();
        this.tabTitles = testContextSetup.tabTitles;
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void i_type_something_into_something_field(String name, String fieldId) throws Throwable {
        switch (fieldId) {
            case "Name":
                automationPracticePage.getAlertNameInputField().sendKeys(name);
                break;
        }
    }

    @Then("^I click on \"([^\"]*)\" in alert$")
    public void i_click_on_something_in_alert(String desiredAction) throws Throwable {
        switch (desiredAction) {
            case "Accept":
                switchTo().alert().accept();
                break;
            case "Dismiss":
                switchTo().alert().dismiss();
                break;
        }


    }

    @When("^I scroll to the end of page$")
    public void i_scroll_to_the_end_of_page()  {
        automationPracticePage.getSoapuiPrelinkFooter().scrollIntoView(true);
    }

    @Then("^I open \"([^\"]*)\" prelink in new tab$")
    public void i_open_something_prelink_in_new_tab(String prelinkId) {
        switch (prelinkId) {
            case "Soapui" -> automationPracticePage.getSoapuiPrelinkFooter().sendKeys(Keys.COMMAND, Keys.ENTER);
            case "Appium" -> automationPracticePage.getAppiumPrelinkFooter().sendKeys(Keys.COMMAND, Keys.ENTER);
        }
    }

    @Then("^I see tabs should have title \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\"$")
    public void i_see_tabs_should_have_title_something_and_something_and_something(String firstTitle, String secondTitle, String thirdTitle) {
        Boolean verifyTabs = false;
        if (tabTitles.contains(firstTitle.toLowerCase()) && tabTitles.contains(secondTitle.toLowerCase())
                && tabTitles.contains(thirdTitle.toLowerCase())) {
            verifyTabs = true;
        }
        Assert.assertEquals(verifyTabs,true);
    }


    @And("^I get title of every opened tab$")
    public void i_get_title_of_every_opened_tab() {

        Set<String> handles = WebDriverRunner.getWebDriver().getWindowHandles();

        for (String handle : handles) {
            WebDriverRunner.getWebDriver().switchTo().window(handle);
            tabTitles.add(WebDriverRunner.getWebDriver().getTitle().toLowerCase());
        }
        System.out.println(tabTitles);
    }

}
