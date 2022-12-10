package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AmazonPage {
    public AmazonPage() {
        page(this);
    }

    private SelenideElement accountsListElement = $("#nav-link-accountList");
    private SelenideElement accountListElementOptionsContainer = $("#nav-al-container");
    private SelenideElement searchBox = $("#twotabsearchtextbox");


    public SelenideElement getAccountsListElement() {
        return accountsListElement;
    }

    public SelenideElement getAccountListElementOptionsContainer() {
        return accountListElementOptionsContainer;
    }

    public SelenideElement getSearchBox() {
        return searchBox;
    }
}
