package steps;

import com.codeborne.selenide.HoverOptions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;
import utilities.TestContextSetup;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AmazonStepsDefinition {
    private TestContextSetup testContextSetup;
    private AmazonPage amazonPage;

    public AmazonStepsDefinition(TestContextSetup testContextSetup, AmazonPage amazonPage) {
        this.testContextSetup = testContextSetup;
        this.amazonPage = testContextSetup.pageObjectManager.getAmazonPage();
    }

    @When("^I hover over \"([^\"]*)\" element$")
    public void i_hover_over_something_element(String elementId) throws Throwable {
        if(elementId.equalsIgnoreCase("Accounts")) {
            amazonPage.getAccountsListElement().hover();
        }
    }

    @Then("^I see \"([^\"]*)\" should be \"([^\"]*)\" on Amazon page$")
    public void i_see_something_should_be_something_on_amazon_page(String elementId, String desiredCondition) throws Throwable {
        switch (elementId) {
            case "Accounts options container":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    amazonPage.getAccountListElementOptionsContainer().shouldBe(visible);
                } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                    amazonPage.getAccountListElementOptionsContainer().shouldNotBe(visible);
                }
                break;
        }
    }


    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" element$")
    public void i_type_something_into_something_element(String searchTerm, String elementId) throws Throwable {
        switch (elementId) {
            case "Searchbox":
                amazonPage.getSearchBox().val(searchTerm);
                break;
        }
    }
}
