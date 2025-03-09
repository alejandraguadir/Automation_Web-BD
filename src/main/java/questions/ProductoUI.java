package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ProductoUI implements Question<String> {
    private final Target elementoUI;

    public ProductoUI(Target elementoUI) {
        this.elementoUI = elementoUI;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(elementoUI).answeredBy(actor);
    }

    public static ProductoUI desde(Target elementoUI) {
        return new ProductoUI(elementoUI);
    }
}
