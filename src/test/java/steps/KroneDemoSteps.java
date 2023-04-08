package steps;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.KroneHomePage;
import utilities.TestContextSetup;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class KroneDemoSteps {

    private final TestContextSetup testContextSetup;
    private final KroneHomePage kroneHomePage;

    public KroneDemoSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.kroneHomePage = testContextSetup.pageObjectManager.getKroneHomePage();
    }

    @When("^I scroll to the \"([^\"]*)\" of the page$")
    public void i_scroll_to_something(String elementId) {
        switch (elementId) {
            case "Footer":
                kroneHomePage.getFooterSection().scrollIntoView(false);
                break;
        }
    }

    @And("^I accept all cookies if notification is shown$")
    public void i_accept_cookies() {
        if(kroneHomePage.getButtonAcceptAllCookies().is(visible)) {
            kroneHomePage.getButtonAcceptAllCookies().click();
        }
    }

    @And("^I click on \"([^\"]*)\" icon$")
    public void i_click_on_icon(String iconId) {
        switch (iconId) {
            case "Linkedin":
                kroneHomePage.getIconLinkedIn().click();
                break;
            case "Instagram":
                kroneHomePage.getIconInstagram().click();
                break;
        }
    }

    @And("^I switch to newly opened tab$")
    public void i_switch_to_tab() {
        switchTo().window(1);
    }

    @Then("^I am on correct \"([^\"]*)\" url$")
    public void i_am_on_correct_url(String urlId) {
        String expectedUrl;
        switch (urlId) {
            case "Linkedin":
                expectedUrl = "https://www.linkedin.com/company/kroneconsulting/";
                Assert.assertEquals(url(),expectedUrl);
                break;
            case "Instagram":
                expectedUrl = "https://www.instagram.com/krone.consulting/";
                Assert.assertEquals(url(),expectedUrl);
        }
    }

}
