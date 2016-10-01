package lab3;

import com.codeborne.selenide.Configuration;
import lab3.pages.LoginPage;
import lab3.pages.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 *
 */
public class PageTest {
    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String browserType = "chrome";
    private static String pathToDriver = "C:\\Work\\chromedriver.exe";
    private static String siteToTest = "https://github.com";

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][] {
                {"rigiemp@gmail.com", "344lowe11", "pasevinapolina"},
                {"lalal", "lalala", "lalala"}
        };
    }

    private static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test(dataProvider = "loginData")
    public void pageTest(String email, String password, String username) {
        configSelenide();
        open(siteToTest);

        MainPage mainPage = new MainPage();
        mainPage.loginClick();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmail(email).setPassword(password).login();
        loginPage.checkLogin(username);

        close();
    }
}
