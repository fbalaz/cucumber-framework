package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class EcommercePage {

    public EcommercePage() {
        page(this);
    }

    private List<SelenideElement> productNames = $$(".product-name");
    private List<SelenideElement> addToCartButtons = $$(".product-action button");
    private List<SelenideElement>  quantityFields = $$(".quantity");
    private List<SelenideElement> incrementQuantityButtons = $$(".increment");
    private SelenideElement cartIcon = $(".cart-icon img");
    private  SelenideElement proceedToCheckoutButton = $x("//button[text()='PROCEED TO CHECKOUT']");

    public List<SelenideElement> getProductNames() {
        return productNames;
    }

    public List<SelenideElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public List<SelenideElement> getQuantityFields() {
        return quantityFields;
    }

    public List<SelenideElement>  getIncrementQuantityButtons() {
        return incrementQuantityButtons;
    }

    public SelenideElement getCartIcon() {
        return cartIcon;
    }

    public SelenideElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }
}
