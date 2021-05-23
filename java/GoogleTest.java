import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @Test
    void selenideSearchTest() {
        open("https://www.google.com/");

        $(byName("q")).setValue("selenide").pressEnter();

        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchTest() {
        open("https://www.google.com/");

        $(byName("q")).setValue("Allure testops").pressEnter();

        $("#search").shouldHave(text("qameta.io"));
    }
}