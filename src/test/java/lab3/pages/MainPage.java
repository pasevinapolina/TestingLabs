package lab3.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 *
 */
public class MainPage {
    private By loginLink = By.xpath("html/body/header/div/div/div/a[2]");

    public MainPage loginClick() {
        $(loginLink).click();
        return this;
    }

}
