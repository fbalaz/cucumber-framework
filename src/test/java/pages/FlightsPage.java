package pages;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FlightsPage {

    public FlightsPage() {
        page(this);
    }

    private SelenideElement currencyStaticDropdown = $("#ctl00_mainContent_DropDownListCurrency");
    private SelenideElement autoSuggestCountryDropdown = $("#autosuggest");
    private List<SelenideElement> autoSuggestCountryDropdownOptionsList = $$(".ui-menu-item a");
    private SelenideElement passengersDropdown = $("#divpaxinfo");
    private SelenideElement addAdultPassenger = $("#hrefIncAdt");
    private SelenideElement deductAdultPassenger = $("#hrefDecAdt");
    private SelenideElement addChildPassenger = $("#hrefIncChd");
    private SelenideElement deductChildPassenger = $("#hrefDecChd");
    private SelenideElement addInfantPassenger = $("#hrefIncInf");
    private SelenideElement deductInfantPassenger = $("#hrefDecInf");
    private SelenideElement departureDropdown = $("#ctl00_mainContent_ddl_originStation1_CTXT");
    private List<SelenideElement> depatureDropdownOptionsList = $$("div.dropdownDiv ul li a");
    private SelenideElement arrivalDropdown = $("#ctl00_mainContent_ddl_destinationStation1_CTXT");
    private List<SelenideElement> arrivalDropdownOptionsList = $$("div.dropdownDiv ul li a ");
    private SelenideElement roundTripRadioButton = $("#ctl00_mainContent_rbtnl_Trip_1");
    private SelenideElement departDateDatePickerIcon = $("body > form:nth-child(1) > div:nth-child(12) > " +
            "div:nth-child(2) > div:nth-child(1) > div:nth-child(17) > div:nth-child(2) > div:nth-child(2) >" +
            " div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(4)");
    private SelenideElement departureMonth = $x("(//div[@class='ui-datepicker-title'])[1]");
    private List<SelenideElement> departureDatesOptionsList = $$(".ui-state-default");
    private SelenideElement departureDateField = $("#ctl00_mainContent_view_date1");
    private SelenideElement nextMonthSelector = $(".ui-datepicker-next.ui-corner-all");
    public SelenideElement getCurrencyStaticDropdown() {
        return currencyStaticDropdown;
    }

    public SelenideElement getAutoSuggestCountryDropdown() {
        return autoSuggestCountryDropdown;
    }

    public List<SelenideElement> getAutoSuggestCountryDropdownOptionsList() {
        return autoSuggestCountryDropdownOptionsList;
    }


    public SelenideElement getPassengersDropdown() {
        return passengersDropdown;
    }

    public SelenideElement getAddAdultPassenger() {
        return addAdultPassenger;
    }

    public SelenideElement getDeductAdultPassenger() {
        return deductAdultPassenger;
    }

    public SelenideElement getAddChildPassenger() {
        return addChildPassenger;
    }

    public SelenideElement getDeductChildPassenger() {
        return deductChildPassenger;
    }

    public SelenideElement getAddInfantPassenger() {
        return addInfantPassenger;
    }

    public SelenideElement getDeductInfantPassenger() {
        return deductInfantPassenger;
    }

    public SelenideElement getDepartureDropdown() {
        return departureDropdown;
    }

    public List<SelenideElement> getDepatureDropdownOptionsList() {
        return depatureDropdownOptionsList;
    }

    public SelenideElement getArrivalDropdown() {
        return arrivalDropdown;
    }

    public List<SelenideElement> getArrivalDropdownOptionsList() {
        return arrivalDropdownOptionsList;
    }

    public SelenideElement getRoundTripRadioButton() {
        return roundTripRadioButton;
    }

    public SelenideElement getDepartDateDatePickerIcon() {
        return departDateDatePickerIcon;
    }

    public SelenideElement getDepartureMonth() {
        return departureMonth;
    }

    public List<SelenideElement> getDepartureDatesOptionsList() {
        return departureDatesOptionsList;
    }

    public SelenideElement getDepartureDateField() {
        return departureDateField;
    }

    public SelenideElement getNextMonthSelector() {
        return nextMonthSelector;
    }
}


