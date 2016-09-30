package lab2.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 *
 */
public class SearchPage {
    private By searchField = By.xpath("html/body/div[2]/div/div/form/label/input");
    private By resultField = By.xpath(".//*[@id='search_form']/div[2]/div[1]/input[1]");

    public SearchPage inputRequest(String searchString) {
        $(searchField).setValue(searchString);
        return this;
    }

    public SearchPage search() {
        $(searchField).pressEnter();
        return this;
    }

    public SearchPage checkResults(String result) {
        $(resultField).shouldHave(Condition.attribute("value", result));
        return this;
    }
}
