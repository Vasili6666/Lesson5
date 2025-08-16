import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

    public class DragDropTest {

        @Test
        public void testDragAndDropWithActions() {

            open("https://the-internet.herokuapp.com/drag_and_drop");
            String originalA = $("#column-a").getText();
            String originalB = $("#column-b").getText();
            actions().clickAndHold($("#column-a"))
                    .moveToElement($("#column-b"))
                    .release()
                    .perform();
            $("#column-a").shouldHave(Condition.text(originalB));
            $("#column-b").shouldHave(Condition.text(originalA));
        }


    }

