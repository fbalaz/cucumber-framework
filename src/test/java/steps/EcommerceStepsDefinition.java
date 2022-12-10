package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EcommercePage;
import utilities.TestContextSetup;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class EcommerceStepsDefinition {

    private TestContextSetup testContextSetup;
    private EcommercePage ecommercePage;

    public EcommerceStepsDefinition(TestContextSetup testContextSetup, EcommercePage ecommercePage) {
        this.testContextSetup = testContextSetup;
        this.ecommercePage = testContextSetup.pageObjectManager.getEcommercePage();
    }

    @Then("^\"([^\"]*)\" button should be \"([^\"]*)\"$")
    public void something_button_should_be_something(String buttonId, String desiredCondition) throws Throwable {
        switch (buttonId) {
            case "Proceed to checkout":
                if(desiredCondition.equalsIgnoreCase("visible")) {
                    ecommercePage.getProceedToCheckoutButton().shouldBe(visible);
                } else if (desiredCondition.equalsIgnoreCase("invisible")) {
                    ecommercePage.getProceedToCheckoutButton().shouldNotBe(visible);
                }
                break;
        }
    }

    @And("^I add \"([^\"]*)\" into cart$")
    public void i_add_something_into_cart(String product) throws Throwable {
        for (int i = 0; i < ecommercePage.getProductNames().size(); i++) {
            if (ecommercePage.getProductNames().get(i).getText().contains(product)) {
                ecommercePage.getAddToCartButtons().get(i).click();
                break;
            }
        }
    }

    @And("^I add \"([^\"]*)\" of quantity \"([^\"]*)\" into cart$")
    public void i_add_something_of_quantity_something_into_cart(String productId, String quantity) throws Throwable {
        for (int i = 0; i < ecommercePage.getProductNames().size(); i++) {
            if(ecommercePage.getProductNames().get(i).getText().contains(productId)) {
                while (!ecommercePage.getQuantityFields().get(i).getValue().equalsIgnoreCase(quantity)) {
                    ecommercePage.getIncrementQuantityButtons().get(i).click();
                }
                ecommercePage.getAddToCartButtons().get(i).click();
                break;
            }
        }
    }


}
