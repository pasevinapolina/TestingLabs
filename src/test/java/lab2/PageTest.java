package lab2;

import com.codeborne.selenide.Configuration;
import lab2.pages.LoginPage;
import lab2.pages.MainPage;
import lab2.pages.SearchPage;
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

    private static void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void pageTest() {
        configSelenide();
        open(siteToTest);

        MainPage mainPage = new MainPage();
        mainPage.loginClick();

        LoginPage loginPage = new LoginPage();
        String testEmail = "YOUR LOGIN";
        String testPassword = "YOUR PASSWORD";
        loginPage.setEmail(testEmail).setPassword(testPassword).login();

        SearchPage searchPage = new SearchPage();
        String searchString = "java";
        String result = "java";
        searchPage.inputRequest(searchString).search().checkResults(result);

        close();
    }
}
