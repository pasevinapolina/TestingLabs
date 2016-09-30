package lab2.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 *
 */
public class LoginPage {

    private By emailField = By.xpath(".//*[@id='login_field']");
    private By loginField = By.xpath(".//*[@id='password']");
    private By submit = By.xpath(".//*[@id='login']/form/div[4]/input[3]");

    public LoginPage setEmail(String email) {
        $(emailField).sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(loginField).sendKeys(password);
        return this;
    }

    public LoginPage login() {
        $(submit).click();
        return this;
    }
}
