package pages;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;


public class KroneHomePage {
    public KroneHomePage() { page(this); }


    private final SelenideElement footerSection = $("footer.et-l.et-l--footer");
    private final SelenideElement iconLinkedIn = $(".et-social-linkedin");
    private final SelenideElement iconInstagram = $(".et-social-instagram");
    private final SelenideElement buttonAcceptAllCookies = $("#wt-cli-accept-all-btn");

    public SelenideElement getFooterSection() {
        return footerSection;
    }

    public SelenideElement getIconLinkedIn() {
        return iconLinkedIn;
    }

    public SelenideElement getButtonAcceptAllCookies() {
        return buttonAcceptAllCookies;
    }

    public SelenideElement getIconInstagram() {
        return iconInstagram;
    }
}
