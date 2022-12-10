package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPagePracticePage {
    public LoginPagePracticePage() {
        page(this);
    }

    private SelenideElement blinkingTextPrelink = $(".blinkingText");
    private SelenideElement userNameField = $("#username");
    private SelenideElement contactEmailElement = $("a[href$='mailto:mentor@rahulshettyacademy.com']");

    public SelenideElement getBlinkingTextPrelink() {
        return blinkingTextPrelink;
    }

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getContactEmailElement() {
        return contactEmailElement;
    }
}
