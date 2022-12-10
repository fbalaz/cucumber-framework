package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPagePracticePage;
import utilities.GenericUtils;
import utilities.TestContextSetup;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPagePracticeStepsDefinition {

    private TestContextSetup testContextSetup;
    private LoginPagePracticePage loginPagePracticePage;
    private GenericUtils genericUtils;
    private String extractedContactEmail;

    public LoginPagePracticeStepsDefinition(TestContextSetup testContextSetup, LoginPagePracticePage loginPagePracticePage) {
        this.testContextSetup = testContextSetup;
        this.loginPagePracticePage = testContextSetup.pageObjectManager.getLoginPagePracticePage();
        this.genericUtils = testContextSetup.genericUtils;
        this.extractedContactEmail = testContextSetup.extractedContactEmail;
    }

    @When("^I click on \"([^\"]*)\" element$")
    public void i_click_on_something_element(String elementId) {
        if(elementId.equalsIgnoreCase("Free access prelink")) {
            loginPagePracticePage.getBlinkingTextPrelink().click();
        }
    }

    @And("^I switch tab$")
    public void i_switch_tab()  {
        genericUtils.switchWindow();
    }

    @Then("^I see \"([^\"]*)\" element should be \"([^\"]*)\"$")
    public void i_see_something_element_should_be_something(String elementId, String desiredCondition) throws Throwable {
       switch (elementId) {
           case "Contact email":
               if(desiredCondition.equalsIgnoreCase("visible")) {
                   loginPagePracticePage.getContactEmailElement().shouldBe(visible);
               } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                   loginPagePracticePage.getContactEmailElement().shouldNotBe(visible);
               }
       }
    }

    @Then("^I see extracted text in \"([^\"]*)\" field$")
    public void i_see_extracted_text_in_something_field(String elementId) throws Throwable {
        switch (elementId) {
            case "Username":
                loginPagePracticePage.getUserNameField().shouldHave(value(extractedContactEmail));
                break;
        }
    }

    @And("^I extract \"([^\"]*)\" element text$")
    public void i_extract_something_element_text(String elementId) throws Throwable {
        extractedContactEmail = loginPagePracticePage.getContactEmailElement().getText();
    }

    @And("^I type extracted text into \"([^\"]*)\" field$")
    public void i_type_extracted_text_into_something_field(String elementId) throws Throwable {
        if(elementId.equalsIgnoreCase("Username")) {
            loginPagePracticePage.getUserNameField().val(extractedContactEmail);
        }
    }

}
