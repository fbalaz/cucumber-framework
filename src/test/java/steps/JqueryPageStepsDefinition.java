package steps;


import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.JqueryPage;
import utilities.TestContextSetup;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class JqueryPageStepsDefinition {

    private TestContextSetup testContextSetup;
    private JqueryPage jqueryPage;

    public JqueryPageStepsDefinition(TestContextSetup testContextSetup, JqueryPage jqueryPage) {
        this.testContextSetup = testContextSetup;
        this.jqueryPage = testContextSetup.pageObjectManager.getJqueryPage();
    }

    @When("^I switch to \"([^\"]*)\" element$")
    public void i_switch_to_something_element(String elementId) {
       if(elementId.equalsIgnoreCase("Frame")) {
        switchTo().frame(jqueryPage.getFrameElement());
       }
    }

    @Then("^I drag \"([^\"]*)\" element and drop it into \"([^\"]*)\" element$")
    public void i_drag_something_element_and_drop_it_into_something_element(String sourceId, String targetId)  {
        if(sourceId.equalsIgnoreCase("Draggable") && targetId.equalsIgnoreCase("Droppable")) {
           actions().moveToElement(jqueryPage.getDraggableSquare()).dragAndDrop(jqueryPage.getDraggableSquare(),
                   jqueryPage.getDroppableSquare()).perform();

        }

    }
}
