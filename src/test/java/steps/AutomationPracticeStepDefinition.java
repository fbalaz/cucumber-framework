package steps;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.AutomationPracticePage;
import utilities.TestContextSetup;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Set;



public class AutomationPracticeStepDefinition {

    private TestContextSetup testContextSetup;
    private AutomationPracticePage automationPracticePage;
    private ArrayList<String> tabTitles;
    private String extractedUrl;
    private HttpURLConnection connection;

    public AutomationPracticeStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.automationPracticePage = testContextSetup.pageObjectManager.getAutomationPracticePage();
        this.tabTitles = testContextSetup.tabTitles;
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void i_type_something_into_something_field(String name, String fieldId) throws Throwable {
        switch (fieldId) {
            case "Name":
                automationPracticePage.getAlertNameInputField().sendKeys(name);
                break;
        }
    }

    @Then("^I click on \"([^\"]*)\" in alert$")
    public void i_click_on_something_in_alert(String desiredAction) throws Throwable {
        switch (desiredAction) {
            case "Accept":
                switchTo().alert().accept();
                break;
            case "Dismiss":
                switchTo().alert().dismiss();
                break;
        }


    }

    @When("^I scroll to the end of page$")
    public void i_scroll_to_the_end_of_page()  {
        automationPracticePage.getSoapuiPrelinkFooter().scrollIntoView(true);
    }

    @Then("^I open \"([^\"]*)\" prelink in new tab$")
    public void i_open_something_prelink_in_new_tab(String prelinkId) {
        switch (prelinkId) {
            case "Soapui" -> automationPracticePage.getSoapuiPrelinkFooter().sendKeys(Keys.COMMAND, Keys.ENTER);
            case "Appium" -> automationPracticePage.getAppiumPrelinkFooter().sendKeys(Keys.COMMAND, Keys.ENTER);
            case "Broken Link" -> automationPracticePage.getBrokenLinkPrelink().sendKeys(Keys.COMMAND, Keys.ENTER);

        }
    }

    @Then("^I see tabs should have title \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\"$")
    public void i_see_tabs_should_have_title_something_and_something_and_something(String firstTitle, String secondTitle, String thirdTitle) {
        Boolean verifyTabs = false;
        if (tabTitles.contains(firstTitle.toLowerCase()) && tabTitles.contains(secondTitle.toLowerCase())
                && tabTitles.contains(thirdTitle.toLowerCase())) {
            verifyTabs = true;
        }
        Assert.assertEquals(verifyTabs,true);
    }


    @And("^I get title of every opened tab$")
    public void i_get_title_of_every_opened_tab() {

        Set<String> handles = WebDriverRunner.getWebDriver().getWindowHandles();

        for (String handle : handles) {
            WebDriverRunner.getWebDriver().switchTo().window(handle);
            tabTitles.add(WebDriverRunner.getWebDriver().getTitle().toLowerCase());
        }
        System.out.println(tabTitles);
    }

    @When("^I scroll onto \"([^\"]*)\" element$")
    public void i_scroll_onto_something_element(String elementId) {
        if(elementId.equalsIgnoreCase("Webtable")) {
            automationPracticePage.getWebTable().scrollIntoView(true);
        }
    }

    @Then("^I see total amount count is equal to value in \"([^\"]*)\" element$")
    public void i_see_total_amount_count_is_equal_to_value_in_something_element(String elementId)  {
        int totalValueFromTable = 0;
        int parsedExtractedAmount = 0;
        if(elementId.equalsIgnoreCase("Total Amount Collected")) {
            String[] totalElementCountWholeText = automationPracticePage.getTotalAmount().getText()
                    .replaceAll(" ","").split(":");
            String extractedAmount = totalElementCountWholeText[1];
            parsedExtractedAmount = Integer.parseInt(extractedAmount);
        }
        for (SelenideElement s : automationPracticePage.getAmountColumnCells()) {
            String amountFromCell = s.getText();
            int parsedAmountFromCell = Integer.parseInt(amountFromCell);
            totalValueFromTable += parsedAmountFromCell;
        }
        Assert.assertEquals(totalValueFromTable, parsedExtractedAmount);

    }

    @And("^I scroll inside \"([^\"]*)\" element$")
    public void i_scroll_inside_something_element(String elementId)  {
       if (elementId.equalsIgnoreCase("Webtable")) {
           executeJavaScript("document.querySelector('div.tableFixHead').scrollTop=5000");
       }
    }

    @Then("^I extract url from \"([^\"]*)\" prelink element$")
    public void i_extract_url_from_something_prelink_element(String elementId)  {
        if(elementId.equalsIgnoreCase("Broken Link")) {
            this.extractedUrl = automationPracticePage.getBrokenLinkPrelink().getAttribute("href");
        }
    }

    @Then("^I check HTTP code should be \"(\\d+)\"$")
    public void i_check_http_code_should_be_something(int expectedErrorCode) throws IOException {
        int actualErrorCode = connection.getResponseCode();
        System.out.println(actualErrorCode);
        Assert.assertEquals(actualErrorCode,expectedErrorCode);
    }

    @And("^I navigate to extracted url$")
    public void i_navigate_to_extracted_url() throws IOException {
        this.connection = (HttpURLConnection) new URL(this.extractedUrl).openConnection();
        this.connection.setRequestMethod("GET");
        this.connection.connect();
    }


}
