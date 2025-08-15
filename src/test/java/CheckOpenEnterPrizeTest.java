import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckOpenEnterPrizeTest {
    @Test
    void testEnterprisePageOpening() {
        // открыть страницу
        open("https://github.com/");
        // найти элемент "Solutions" + hover
        $(byText("Solutions")).hover();
        // найти "Enterprises" + кликнуть
        $(byText("Enterprises")).click();
        // проверить открытие страницы
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
        // закрыть страницу
        Selenide.closeWebDriver();
    }

}
