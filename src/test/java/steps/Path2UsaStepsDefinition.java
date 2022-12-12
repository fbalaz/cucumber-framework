package steps;

import static com.codeborne.selenide.Selenide.*;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import pages.Path2UsaPage;
import utilities.*;

import static com.codeborne.selenide.Condition.*;

public class Path2UsaStepsDefinition {
    private TestContextSetup testContextSetup;
    private GenericUtils genericUtils;
    private Path2UsaPage path2UsaPage;

    public Path2UsaStepsDefinition(TestContextSetup testContextSetup, GenericUtils genericUtils, Path2UsaPage path2UsaPage) {
        this.testContextSetup = testContextSetup;
        this.genericUtils = testContextSetup.genericUtils;
        this.path2UsaPage = testContextSetup.pageObjectManager.getPath2UsaPage();
    }

    @When("^I click on \"([^\"]*)\" field$")
    public void i_click_on_something_field(String elementId)  {
        if(elementId.equalsIgnoreCase("Date of travel")) {
            path2UsaPage.getDateOfTravelField().click();
        }
    }

    @Then("^I see \"([^\"]*)\" element should be \"([^\"]*)\" on Path2Usa page$")
    public void i_see_something_element_should_be_something_on_path2usa_page(String elementId, String desiredCondition)  {
        switch (elementId) {
            case "Datepicker":
                if (desiredCondition.equalsIgnoreCase("visible")) {
                    path2UsaPage.getDatePicker().shouldBe(visible);
                } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                    path2UsaPage.getDatePicker().shouldNotBe(visible);
                } break;
        }
    }

    @Then("^I see \"([^\"]*)\" field should have value \"([^\"]*)\"$")
    public void i_see_something_field_should_have_value_something(String elementId, String expectedValue)  {
        if(elementId.equalsIgnoreCase("Date of travel")) {
            path2UsaPage.getDateOfTravelField().shouldHave(value(expectedValue));
        }
    }

    @And("^I select \"([^\"]*)\" as a departure year on Path2Usa page$")
    public void i_select_something_as_a_departure_year_on_path2usa_page(String year) {
       while(!path2UsaPage.getCurrentYear().getValue().equalsIgnoreCase(year)) {
           path2UsaPage.getNextMonthArrow().click();
       }
    }

    @And("^I select \"([^\"]*)\" as a departure month on Path2Usa page$")
    public void i_select_something_as_a_departure_month_on_path2usa_page(String month)  {
        while(!path2UsaPage.getCurrentMonth().getText().equalsIgnoreCase(month)) {
            path2UsaPage.getNextMonthArrow().click();
        }
    }

    @And("^I select \"([^\"]*)\" as a departure day$")
    public void i_select_something_as_a_departure_day(String desiredDepartureDay)  {
        for (int i = 0; i < path2UsaPage.getDaysInDatepicker().size(); i++) {
            if (path2UsaPage.getDaysInDatepicker().get(i).getText().equalsIgnoreCase(desiredDepartureDay)) {
                path2UsaPage.getDaysInDatepicker().get(i).click();
                break;
            }
        }

    }
    @Then("^I scroll to have element in the middle of the page$")
    public void i_scroll_to_have_element_in_the_middle_of_the_page()  {
       path2UsaPage.getDateOfTravelField().scrollIntoView(true);
    }
}
