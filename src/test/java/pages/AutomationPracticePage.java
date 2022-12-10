package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AutomationPracticePage {

    public AutomationPracticePage() {
        page(this);
    }

    private SelenideElement alertNameInputField = $("#name");
    private SelenideElement alertButton = $("#alertbtn");
    private SelenideElement confirmButton = $("#confirmbtn");
    private  SelenideElement soapuiPrelinkFooter = $("table > tbody > tr " +
            "> td:first-child>ul > li:nth-child(3) a");
    private SelenideElement appiumPrelink = $("table > tbody > tr > td:first-child > " +
            "ul > li:nth-child(4) a");

    public SelenideElement getAlertNameInputField() {
        return alertNameInputField;
    }

    public SelenideElement getAlertButton() {
        return alertButton;
    }

    public SelenideElement getConfirmButton() {
        return confirmButton;
    }

    public SelenideElement getSoapuiPrelinkFooter() {
        return soapuiPrelinkFooter;
    }

    public SelenideElement getAppiumPrelinkFooter() {
        return appiumPrelink;
    }
}
