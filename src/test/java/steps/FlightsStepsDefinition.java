package steps;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import enumerators.DestinationsEnumerator;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightsPage;
import utilities.TestContextSetup;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FlightsStepsDefinition {

    private TestContextSetup testContextSetup;
    private FlightsPage flightsPage;

    public FlightsStepsDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.flightsPage = testContextSetup.pageObjectManager.getFlightsPage();
    }


    @When("^I choose \"([^\"]*)\" from \"([^\"]*)\" dropdown$")
    public void i_choose_something_from_something_dropdown(String value, String dropdownName) throws Throwable {
        if(dropdownName.equals("Currency")) {
            flightsPage.getCurrencyStaticDropdown().selectOptionByValue(value);
        }

    }

    @Then("^I see \"([^\"]*)\" is chosen currency$")
    public void i_see_something_is_chosen_currency(String value) throws Throwable {
        flightsPage.getCurrencyStaticDropdown().shouldHave(text(value));
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" dropdown$")
    public void i_type_something_into_something_dropdown(String countryShortName, String dropdownId) throws Throwable {
        if(dropdownId.equals("Autosuggest")) {
            flightsPage.getAutoSuggestCountryDropdown().sendKeys(countryShortName);
        }
    }

    @And("^I click on \"([^\"]*)\" in \"([^\"]*)\" list$")
    public void i_click_on_something_in_something_list(String desiredOption, String optionsListId) throws Throwable {
        if(optionsListId.equals("Autosuggest options list")) {
            for (SelenideElement selenideElement : flightsPage.getAutoSuggestCountryDropdownOptionsList() ) {
                if(selenideElement.getText().contains(desiredOption)) {
                    selenideElement.click();
                    break;
                }
            }
        } else if(optionsListId.equalsIgnoreCase("Departure options list")) {
            for (SelenideElement s : flightsPage.getDepatureDropdownOptionsList() ) {
                if(s.getText().contains(desiredOption)) {
                    s.click();
                }
            }
        } else if (optionsListId.equalsIgnoreCase("Arrival otions list")) {
            for (DestinationsEnumerator value : DestinationsEnumerator.values()) {
                if(value.toString().equalsIgnoreCase(desiredOption)) {
                    $x("(//a[@value='" + value.getXpath() + "'])[2]").click();
                }
            }
        } else if (optionsListId.equalsIgnoreCase("Departure dates options list")) {
            for (SelenideElement s : flightsPage.getDepartureDatesOptionsList() ) {
                if(s.getText().equalsIgnoreCase(desiredOption)) {
                    s.click();
                    break;
                }
            }
        }
    }

    @Then("^I see \"([^\"]*)\" in \"([^\"]*)\" dropdown$")
    public void i_see_something_in_something_dropdown(String desiredText, String dropdownId) throws Throwable {
        if(dropdownId.equalsIgnoreCase("Autosuggest")) {
            flightsPage.getAutoSuggestCountryDropdown().shouldHave(value(desiredText));
        }
        else if(dropdownId.equalsIgnoreCase("Passenger")) {
            flightsPage.getPassengersDropdown().shouldHave(text(desiredText));
        } else if (dropdownId.equalsIgnoreCase("Arrival")) {
            flightsPage.getArrivalDropdown().shouldHave(value(desiredText));
        }
    }

    @When("^I click on \"([^\"]*)\" dropdown$")
    public void i_click_on_something_dropdown(String dropdownId) throws Throwable {
        if(dropdownId.equalsIgnoreCase("Passenger")) {
            flightsPage.getPassengersDropdown().click();
        } else if(dropdownId.equalsIgnoreCase("Departure")) {
            flightsPage.getDepartureDropdown().click();
        }
    }

    @And("^I choose \"(\\d+)\" passengers? as \"([^\"]*)\"$")
    public void i_choose_number_passengers_as_something(int numberOfPassengers, String typeOfPassengers) throws Throwable {
        switch(typeOfPassengers) {
            case "Adult":
                for (int i = 0; i < numberOfPassengers - 1; i++) {
                    flightsPage.getAddAdultPassenger().click();
                }
                break;
            case "Child":
                for (int i = 0; i < numberOfPassengers; i++) {
                    flightsPage.getAddChildPassenger().click();
                }
                break;
            case "Infant":
                for (int i = 0; i < numberOfPassengers; i++) {
                    flightsPage.getAddInfantPassenger().click();
                }
        }
        flightsPage.getPassengersDropdown().click();
    }

    @Then("^I see \"([^\"]*)\" should be \"([^\"]*)\"$")
    public void i_see_something_should_be_something(String optionsListId, String desiredCondition) throws Throwable {
        switch(optionsListId) {
            case "Autosuggest options list":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    flightsPage.getAutoSuggestCountryDropdownOptionsList().get(0).shouldBe(visible);
                } else if(desiredCondition.equalsIgnoreCase("invisible")) {
                    flightsPage.getAutoSuggestCountryDropdownOptionsList().get(0).shouldNotBe(visible);
                }
                break;
            case "Departure options list":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    flightsPage.getDepatureDropdownOptionsList().get(0).shouldBe(visible);
                } else if(desiredCondition.equalsIgnoreCase("invisible")) {
                    flightsPage.getDepatureDropdownOptionsList().get(0).shouldNotBe(visible);
                }
                break;
            case "Arrival options list":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    flightsPage.getArrivalDropdownOptionsList().get(0).shouldBe(visible);
                } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                    flightsPage.getArrivalDropdownOptionsList().get(0).shouldNotBe(visible);
                }
                break;
            case "Departure dates options list":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    flightsPage.getDepartureDatesOptionsList().get(0).shouldBe(visible);
                } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                    flightsPage.getDepartureDatesOptionsList().get(0).shouldNotBe(visible);
                }
                break;
        }
    }
    @When("^I click on \"([^\"]*)\" radiobutton$")
    public void i_click_on_something_radiobutton(String radioButtonId) throws Throwable {
        if(radioButtonId.equalsIgnoreCase("Round trip")) {
            flightsPage.getRoundTripRadioButton().click();
        }
    }

    @And("^I click on \"([^\"]*)\" datepicker icon$")
    public void i_click_on_something_datepicker_icon(String datePickerId) throws Throwable {
       if(datePickerId.equalsIgnoreCase("Depart date")) {
           flightsPage.getDepartDateDatePickerIcon().click();
       }
    }

    @And("^I select \"([^\"]*)\" as a departure month$")
    public void i_select_something_as_a_departure_month(String departureMonth) throws Throwable {
        while(!flightsPage.getDepartureMonth().getText().equalsIgnoreCase(departureMonth)) {
            flightsPage.getNextMonthSelector().click();

        }
    }


    @Then("^I see \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void i_see_something_in_something_field(String desiredText, String fieldId) throws Throwable {
        if(fieldId.equalsIgnoreCase("Departure date")) {
            flightsPage.getDepartureDateField().shouldHave(value(desiredText));
        }
    }

}


