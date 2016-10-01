package lab3.pages;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class LoginPage {

    private By emailField = By.xpath(".//*[@id='login_field']");
    private By loginField = By.xpath(".//*[@id='password']");
    private By submit = By.xpath(".//*[@id='login']/form/div[4]/input[3]");
    private By usernameField = By.xpath(".//*[@id='user-links']/li[3]/a");


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

    public LoginPage checkLogin(String username) {
        $(usernameField).click();
        $(By.xpath(".//*[@id='user-links']/li[3]/div/div/div[1]/strong")).shouldHave(Condition.text(username));
        return this;
    }
}
