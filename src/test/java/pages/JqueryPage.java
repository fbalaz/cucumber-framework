package pages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class JqueryPage {
    public JqueryPage() {
        page(this);
    }
    private SelenideElement draggableSquare = $("#draggable");
    private SelenideElement droppableSquare = $(byAttribute("id","droppable"));
    private SelenideElement frameElement = $("iframe.demo-frame");

    public SelenideElement getDraggableSquare() {
        return draggableSquare;
    }

    public SelenideElement getDroppableSquare() {
        return droppableSquare;
    }

    public SelenideElement getFrameElement() {
        return frameElement;
    }

}
