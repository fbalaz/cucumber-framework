package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


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
    private SelenideElement webTable = $("div.tableFixHead");
    private SelenideElement totalAmount = $(".totalAmount");
    private List<SelenideElement> amountColumnCells = $$(".tableFixHead > table > tbody > tr > td:nth-child(4)");

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

    public SelenideElement getWebTable() {
        return webTable;
    }

    public SelenideElement getTotalAmount() {
        return totalAmount;
    }

    public List<SelenideElement> getAmountColumnCells() {
        return amountColumnCells;
    }
}
