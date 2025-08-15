import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

/* Запрограммируйте Drag&Drop с помощью Selenide.actions()
- Откройте https://the-internet.herokuapp.com/drag_and_drop
- Перенесите прямоугольник А на место В
- Проверьте, что прямоугольники действительно поменялись
- В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

*/
    public class DragDropTest {

        @Test
        public void testDragAndDropWithActions() {
            // Открываем страницу
            open("https://the-internet.herokuapp.com/drag_and_drop");

            // Запоминаем исходный текст элементов
            String originalA = $("#column-a").getText();
            String originalB = $("#column-b").getText();

            // Выполняем Drag&Drop через actions()
            actions().clickAndHold($("#column-a"))
                    .moveToElement($("#column-b"))
                    .release()
                    .perform();

            // Проверяем, что элементы поменялись местами
            $("#column-a").shouldHave(Condition.text(originalB));
            $("#column-b").shouldHave(Condition.text(originalA));
        }


    }

