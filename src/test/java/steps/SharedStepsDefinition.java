package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AutomationPracticePage;
import pages.EcommercePage;
import utilities.GenericUtils;
import utilities.TestContextSetup;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SharedStepsDefinition {

    private TestContextSetup testContextSetup;
    private GenericUtils genericUtils;
    private AutomationPracticePage automationPracticePage;
    private EcommercePage ecommercePage;

    public SharedStepsDefinition(TestContextSetup testContextSetup, GenericUtils genericUtils) {
        this.testContextSetup = testContextSetup;
        this.genericUtils = testContextSetup.genericUtils;
        this.automationPracticePage = testContextSetup.pageObjectManager.getAutomationPracticePage();
        this.ecommercePage = testContextSetup.pageObjectManager.getEcommercePage();
    }

    @Given("^I open \"([^\"]*)\" page$")
    public void i_open_something_page(String page) throws Throwable {
        if(page.equalsIgnoreCase("Flights booking")) {
            open("/dropdownsPractise/");
        } else if (page.equalsIgnoreCase("Automation practice")) {
            open("/AutomationPractice/");
        } else if(page.equalsIgnoreCase("Greenkart")) {
            open("/seleniumPractise/#/");
        } else if(page.equalsIgnoreCase("Amazon")) {
            open("https://www.amazon.com");
        } else if (page.equalsIgnoreCase("Login page practice")) {
            open("/loginpagePractise/#/");
        } else if (page.equalsIgnoreCase("Jquery")) {
            open("https://jqueryui.com/droppable/");
        }
    }

    @And("^I wait for \"(\\d+)\" seconds$")
    public void i_wait_for_something_seconds(long seconds) throws Throwable {
        genericUtils.customWait(seconds);
    }

    @And("^I click on \"([^\"]*)\" button$")
    public void i_click_on_something_button(String buttonId) throws Throwable {
        switch (buttonId) {
            case "Alert":
                automationPracticePage.getAlertButton().click();
                break;
            case "Confirm":
                automationPracticePage.getConfirmButton().click();
                break;
            case "Cart":
                ecommercePage.getCartIcon().click();
                break;
            case "Proceed to checkout":
                ecommercePage.getProceedToCheckoutButton().click();
                break;
        }
    }

    @Then("^I close browser$")
    public void i_close_browser() {
        closeWebDriver();
    }
}
