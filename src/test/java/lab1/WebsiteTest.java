package lab1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 *
 */
public class WebsiteTest {

    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "C:\\Work\\chromedriver.exe";

    private static String siteToTest = "https://mail.ru/";
    private static String browserType = "chrome";

    private void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void loginTest() {
        configSelenide();
        open(siteToTest);

        String testEmail = "YOUR EMAIL";
        String testPassword = "YOUR PASSWORD";

        $(By.xpath(".//*[@id='mailbox__login']")).sendKeys(testEmail);
        $(By.xpath(".//*[@id='mailbox__password']")).sendKeys(testPassword);
        $(By.xpath(".//*[@id='mailbox__auth__button']")).click();
        $(By.xpath(".//*[@id='PH_user-email']")).shouldHave(Condition.text(testEmail));

        close();
    }

    @Test
    public void searchTest() {
        configSelenide();
        open(siteToTest);

        String searchString = "hello";
        String resultString = "hello";

        $(By.xpath(".//*[@id='q']")).setValue(searchString).pressEnter();

        $$(By.xpath(".//*[@id='js-result']")).shouldHave(CollectionCondition.size(1));
        $(By.xpath(".//*[@id='js-result_3']/h3/a")).shouldHave(Condition.text(resultString));
        close();
    }

    @Test
    public void emptyFieldWarningTest() {
        configSelenide();
        open(siteToTest);

        $(By.xpath(".//*[@id='PH_regLink']")).click();
        $(By.xpath(".//*[@id='registrationForm']/div[15]/span[2]/button")).click();
        $(By.xpath(".//*[@id='registrationForm']/div[3]/span[2]/span[3]/span")).shouldNot(Condition.empty);
        close();
    }

    @Test
    public void contactsPageTest() {
        configSelenide();
        open(siteToTest);

        String imgTitle = "Игры Mail.Ru";

        $(By.xpath(".//*[@id='portal-headline']/table/tbody/tr/td[1]/a[4]/span")).click();
        $(By.xpath(".//*[@id='portal-menu__toolbar']/div[1]/div/div[1]/div/div/a/img"))
                .shouldHave(Condition.attribute("title", imgTitle));
        close();
    }

    @Test
    public void checkboxTest() {
        configSelenide();
        open(siteToTest);

        if($(By.name("saveauth")).isSelected()) {
            $(By.name("saveauth")).click();
            $(By.name("saveauth")).shouldNotBe(Condition.selected);
        }
        else if(!($(By.name("saveauth")).isSelected())) {
            $(By.name("saveauth")).click();
            $(By.name("saveauth")).shouldBe(Condition.selected);
        }
        close();
    }
}
