import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    static Logger logger = LoggerFactory.getLogger(GoogleTest.class);

    @BeforeAll
    static void config()
    {
        logger.info("@BeforeAll method");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void openGooglePage()
    {
        logger.info("@BeforeEach method");
        open("https://www.google.com/");
    }

    @AfterEach
    void closeBrowser()
    {
        logger.info("@AfterEach method");
        closeWebDriver();
    }

    @Test
    void selenideSearchTest() {
        logger.info("This is the google test");

        $(byName("q")).setValue("selenide").pressEnter();

        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchtest()
    {
        logger.info("This is the allure test");

        $(byName("q")).setValue("Allure Testops").pressEnter();

        $("#search").shouldHave(text("qameta.io"));
    }
}