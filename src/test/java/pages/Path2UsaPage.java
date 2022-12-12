package pages;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Path2UsaPage {

    public Path2UsaPage() {
        page(this);
    }
    private SelenideElement dateOfTravelField = $("#form-field-travel_comp_date");
    private SelenideElement datePicker = $(".flatpickr-innerContainer");
    private SelenideElement currentMonth = $(".flatpickr-current-month");
    private SelenideElement currentYear = $(".numInput.cur-year");
    private SelenideElement nextMonthArrow = $(".flatpickr-next-month");
    private List<SelenideElement> daysInDatepicker = $$("span.flatpickr-day");

    public SelenideElement getDateOfTravelField() {
        return dateOfTravelField;
    }

    public SelenideElement getDatePicker() {
        return datePicker;
    }

    public SelenideElement getCurrentMonth() {
        return currentMonth;
    }

    public SelenideElement getNextMonthArrow() {
        return nextMonthArrow;
    }

    public List<SelenideElement> getDaysInDatepicker() {
        return daysInDatepicker;
    }

    public SelenideElement getCurrentYear() {
        return currentYear;
    }
}
